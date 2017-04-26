package eu.amova.cloud.platform.service.security.configuration;

import eu.amova.cloud.platform.service.security.dao.ClientDetailsRepository;
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
    private ClientDetailsRepository clientDetailsRepository;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsRepository);
//        clients.jdbc(null).
//        clients.inMemory()
//                .withClient("web_app")
//                .scopes("FOO")
//                .autoApprove(true)
//                .authorities("FOO_READ", "FOO_WRITE")
//                .authorizedGrantTypes("implicit","refresh_token", "password", "authorization_code");
    }

//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.tokenStore(tokenStore()).tokenEnhancer(jwtTokenEnhancer()).authenticationManager(authenticationManager);
//    }
//
//    @Autowired
//    @Qualifier("authenticationManagerBean")
//    private AuthenticationManager authenticationManager;
//
//    @Bean
//    public TokenStore tokenStore() {
//        return new JwtTokenStore(jwtTokenEnhancer());
//    }
//
//    @Bean
//    protected JwtAccessTokenConverter jwtTokenEnhancer() {
//        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "mySecretKey".toCharArray());
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("jwt"));
//        return converter;
//    }
}