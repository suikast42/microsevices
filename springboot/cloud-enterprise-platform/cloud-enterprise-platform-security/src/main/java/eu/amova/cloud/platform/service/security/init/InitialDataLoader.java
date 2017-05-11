package eu.amova.cloud.platform.service.security.init;

import eu.amova.cloud.platform.service.security.dao.OAuth2ClientDetailsRepository;
import eu.amova.cloud.platform.service.security.dao.PrivilegeRepository;
import eu.amova.cloud.platform.service.security.dao.RoleRepository;
import eu.amova.cloud.platform.service.security.dao.UserRepository;
import eu.amova.cloud.platform.service.security.persistence.OAuth2ClientDetails;
import eu.amova.cloud.platform.service.security.persistence.Privilege;
import eu.amova.cloud.platform.service.security.persistence.Role;
import eu.amova.cloud.platform.service.security.persistence.User;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author: vuru
 * Date: 27.04.2017
 * Time: 09:18
 */
@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {


    @Autowired
    private Log logger;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;


    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private OAuth2ClientDetailsRepository clientDetailsRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.debug("Init default security settings");
        initPrivileges();
        initRoles();
        initUsers();
        assignDefaultRoles();
        assignPrivileges();
        initClientDetails();
    }


    private void initPrivileges() {
        logger.debug("initPrivileges");
        String appId = "security";
        List<Privilege> securityPriviliges = new ArrayList<>();

        securityPriviliges.add(new Privilege(appId, "READ_PRIVILEGE", "Read app rights"));
        securityPriviliges.add(new Privilege(appId, "WRITE_PRIVILEGE", "Change app rights"));
        privilegeRepository.registerAppPrivileges(appId, securityPriviliges);
    }

    private void initRoles() {
        logger.debug("initRoles");
        for (Role.FixedRoles fixedRole : Role.FixedRoles.values()) {
            Role role = roleRepository.findByName(fixedRole.name());
            if (role == null) {
                role = new Role();
                role.setName(fixedRole.name());
                roleRepository.save(role);
            }
        }
    }

    private void initUsers() {
        logger.debug("initUsers");
        for (User.FixedUsers fixedUser : User.FixedUsers.values()) {
            User user = userRepository.findByLogin(fixedUser.name());
            if (user == null) {
                user = new User();
                user.setEnabled(true);
                user.setLogin(fixedUser.name());
                user.setFirstName(fixedUser.name());
                user.setLastName(fixedUser.name());
                user.setEmail(fixedUser.name() + "@amova.eu");
                user.setLocale(Locale.getDefault());
                user.setPassword(passwordEncoder.encode(fixedUser.name()));
//                user.setPassword(fixedUser.name());
                userRepository.save(user);
            }
        }
    }

    private void assignDefaultRoles() {
        logger.debug("assignDefaultRoles");
        for (Role.FixedRoles fixedRole : Role.FixedRoles.values()) {
            Role role = roleRepository.findByName(fixedRole.name());
            if (    role.getName().equals(Role.FixedRoles.ROLE_Administrator.name()) ||
               role.getName().equals(Role.FixedRoles.ROLE_ACTUATOR.name())
                    ) {
                {
                    User adminUser = userRepository.findByLogin(User.FixedUsers.Admin.name());
                    adminUser.getRoles().add(role);
                    role.getUsers().add(adminUser);
                }
                {
                    User developerUser = userRepository.findByLogin(User.FixedUsers.Developer.name());
                    developerUser.getRoles().add(role);
                    role.getUsers().add(developerUser);
                }
            } else if (role.getName().equals(Role.FixedRoles.ROLE_Developer.name())) {
                {
                    User developerUser = userRepository.findByLogin(User.FixedUsers.Developer.name());
                    developerUser.getRoles().add(role);
                    role.getUsers().add(developerUser);
                }
            } else {
                logger.error(MessageFormat.format("Not handled role for auto assign {0} ", role.getName()));
            }
        }
    }

    private void assignPrivileges() {
        logger.debug("assignPrivileges");
        List<Privilege> all = privilegeRepository.findAll();
        Role adminRole = roleRepository.findByName(Role.FixedRoles.ROLE_Administrator.name());
        Role developerRole = roleRepository.findByName(Role.FixedRoles.ROLE_Developer.name());
        adminRole.getPrivileges().addAll(all);
        developerRole.getPrivileges().addAll(all);

        for (Privilege priv : all) {
            priv.getRoles().add(adminRole);
            priv.getRoles().add(developerRole);
        }
    }

    private void initClientDetails() {
        logger.debug("initClientDetails");
        {
            OAuth2ClientDetails desktop = clientDetailsRepository.findByClientId("desktop");
            if(desktop == null){
                // End users with client credentials
                logger.debug("\tCreating OAuth2ClientDetails desktop");
                desktop =   new OAuth2ClientDetails();
                desktop.setClientId("desktop");
                desktop.setResourceIds("oauth2-resource");
                desktop.setClientSecret(passwordEncoder.encode("secret"));
                desktop.setScope("read,write,trust");
                desktop.setAutoapprove(desktop.getScope());
//            desktop.setAuthorizedGrantTypes("authorization_code,refresh_token,implicit,password,client_credentials");
                desktop.setAuthorizedGrantTypes("refresh_token,password");
                clientDetailsRepository.save(desktop);
            }
        }
        {
            OAuth2ClientDetails scs = clientDetailsRepository.findByClientId("scs");
            if(scs == null){
                //  machine-to-machine authentication where a specific user’s permission to access data is not required
                logger.debug("\tCreating OAuth2ClientDetails scs");
                scs =   new OAuth2ClientDetails();
                scs.setClientId("scs");
                scs.setResourceIds("oauth2-resource");
                scs.setClientSecret(passwordEncoder.encode("secret"));
                scs.setScope("read,write,trust");
                scs.setAutoapprove(scs.getScope());
//            desktop.setAuthorizedGrantTypes("authorization_code,refresh_token,implicit,password,client_credentials");
                scs.setAuthorizedGrantTypes("refresh_token,client_credentials");
                clientDetailsRepository.save(scs);
            }
        }
    }

}
