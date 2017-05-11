package eu.amova.cloud.platform.service.security.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;

/**
 * @author: vuru
 * Date: 19.04.2017
 * Time: 08:35
 */

@Configuration
@EnableAuthorizationServer
//@EnableOAuth2Sso
public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {

//    1. http://localhost:9999/security/oauth/token?grant_type=password&username=Admin&password=Admin

    @Autowired
    @Qualifier(value = "clientDetailsServiceDelegate")
    private ClientDetailsService clientDetailsService;


    @Autowired
    @Qualifier(value = "userDetailsService")
    private UserDetailsService userDetailsService;


    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private PasswordEncoder passwordEncoder;

        @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.passwordEncoder(passwordEncoder)
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
        ;
    }

    @Override 
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .setClientDetailsService(clientDetailsService)

        ;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//       http://localhost:9999/security/oauth/authorize?grant_type=passwords&client_id=desktop&client_secret=secret&username=Admin&password=Admin&response_type=code&redirect_uri=http://localhost:9999/security/test/greeting
//       http://localhost:9999/security/oauth/token?grant_type=password&response_type=code&client_id=desktop&client_secret=secret&username=Admin&password=Admin
        clients.withClientDetails(clientDetailsService);
    }
}