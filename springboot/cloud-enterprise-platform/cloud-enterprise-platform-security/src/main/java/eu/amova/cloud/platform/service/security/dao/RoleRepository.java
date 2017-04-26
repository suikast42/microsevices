package eu.amova.cloud.platform.service.security.dao;

import eu.amova.cloud.platform.service.security.persistence.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: vuru
 * Date: 26.04.2017
 * Time: 16:16
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);


}