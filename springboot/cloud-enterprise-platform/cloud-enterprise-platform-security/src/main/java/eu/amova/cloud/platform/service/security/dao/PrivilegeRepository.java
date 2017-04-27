package eu.amova.cloud.platform.service.security.dao;

import eu.amova.cloud.platform.service.security.persistence.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: vuru
 * Date: 26.04.2017
 * Time: 16:14
 */
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> ,PrivilegeRepositoryExtended {

    Privilege findByName(String name);

}