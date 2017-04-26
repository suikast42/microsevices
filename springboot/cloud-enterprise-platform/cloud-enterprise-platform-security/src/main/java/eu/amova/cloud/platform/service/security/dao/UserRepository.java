package eu.amova.cloud.platform.service.security.dao;

import eu.amova.cloud.platform.service.security.persistence.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: vuru
 * Date: 26.04.2017
 * Time: 16:08
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
