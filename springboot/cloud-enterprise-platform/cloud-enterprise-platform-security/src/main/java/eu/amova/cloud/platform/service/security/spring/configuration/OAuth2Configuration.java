//package eu.amova.cloud.platform.service.security.spring.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
//import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//
//import javax.sql.DataSource;
//
///**
// * @author: vuru
// * Date: 19.04.2017
// * Time: 08:35
// */
//
//@Configuration
//@EnableAuthorizationServer
////@EnableOAuth2Sso
//public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//        oauthServer.passwordEncoder(passwordEncoder)
//                .tokenKeyAccess("permitAll()")
//                .checkTokenAccess("isAuthenticated()")
//        ;
//    }
//
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer configurer) throws Exception {
//        configurer
//                .authorizationCodeServices(authorizationCodeServices())
//                .userDetailsService(userDetailsService)
//                .tokenStore(tokenStore())
//                .authenticationManager(authenticationManager)
//        ;
//
//    }
//
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.jdbc(dataSource).passwordEncoder(passwordEncoder);
//    }
//
//    @Bean
//    public TokenStore tokenStore() {
//        return new JdbcTokenStore(dataSource);
//    }
//
//    @Bean
//    protected AuthorizationCodeServices authorizationCodeServices() {
//        return new JdbcAuthorizationCodeServices(dataSource);
//    }
//
//}