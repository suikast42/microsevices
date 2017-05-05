package eu.amova.cloud.platform.service.security.dao;

import eu.amova.cloud.platform.service.security.persistence.OAuth2ClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: vuru
 * Date: 05.05.2017
 * Time: 10:19
 */
public interface OAuth2ClientDetailsRepository extends JpaRepository<OAuth2ClientDetails, Long> {

    OAuth2ClientDetails findByClientId(String clientId);
}
