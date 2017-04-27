package eu.amova.cloud.platform.service.security.init;

import eu.amova.cloud.platform.service.security.dao.PrivilegeRepository;
import eu.amova.cloud.platform.service.security.dao.UserRepository;
import eu.amova.cloud.platform.service.security.persistence.Privilege;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: vuru
 * Date: 27.04.2017
 * Time: 09:18
 */
@Component
public class InitalDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private Log logger ;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
      initPrivileges();
    }

    private void initPrivileges() {
        String appId ="security";
        List<Privilege> securityPriviliges = new ArrayList<>() ;

        securityPriviliges.add(new Privilege(appId,"READ_PRIVILEGE","Read app rights"));
        securityPriviliges.add(new Privilege(appId,"WRITE_PRIVILEGE","Change app rights"));
        privilegeRepository.registerAppPrivileges(appId,securityPriviliges);
    }
}
