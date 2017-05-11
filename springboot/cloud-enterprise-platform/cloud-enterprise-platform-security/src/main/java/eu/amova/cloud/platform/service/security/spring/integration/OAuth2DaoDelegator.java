package eu.amova.cloud.platform.service.security.spring.integration;

import eu.amova.cloud.platform.service.security.dao.OAuth2ClientDetailsRepository;
import eu.amova.cloud.platform.service.security.persistence.OAuth2ClientDetails;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;

/**
 * @author: vuru
 * Date: 09.05.2017
 * Time: 16:53
 */
@Service("clientDetailsServiceDelegate")
@Transactional
public class OAuth2DaoDelegator implements ClientDetailsService {
    @Autowired
    private Log logger;

    @Autowired
    private OAuth2ClientDetailsRepository clientDetailsRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        logger.debug("loadClientByClientId "+clientId);
        OAuth2ClientDetails byClientId = clientDetailsRepository.findByClientId(clientId);
        if(byClientId == null){
            throw new ClientRegistrationException(MessageFormat.format("Invalid clientid {0}",clientId)) ;
        }
        return new ClientDetailsDto(byClientId);
    }
}
