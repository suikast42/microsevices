package eu.amova.cloud.platform.service.security.configuration;

import eu.amova.cloud.platform.service.security.service.ClientDetailsIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author: vuru
 * Date: 19.04.2017
 * Time: 08:35
 */

@Configuration
@EnableAuthorizationServer
//@EnableOAuth2Sso
public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private ClientDetailsIntegrationService clientDetailsRepository;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsRepository);
    }

}