package eu.amova.cloud.platform.service.security.init;

import eu.amova.cloud.platform.service.security.dao.PrivilegeRepository;
import eu.amova.cloud.platform.service.security.dao.RoleRepository;
import eu.amova.cloud.platform.service.security.dao.UserRepository;
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



    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.debug("Init default security settings");
        initPrivileges();
        initRoles();
        initUsers();
        assignDefaultRoles();
        assignPrivileges();
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
            if (role.getName().equals(Role.FixedRoles.Administrator.name())) {
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
            } else if (role.getName().equals(Role.FixedRoles.Developer.name())) {
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
        Role adminRole = roleRepository.findByName(Role.FixedRoles.Administrator.name());
        Role developerRole = roleRepository.findByName(Role.FixedRoles.Developer.name());
        adminRole.getPrivileges().addAll(all);
        developerRole.getPrivileges().addAll(all);

        for (Privilege priv : all) {
            priv.getRoles().add(adminRole);
            priv.getRoles().add(developerRole);
        }
    }

}