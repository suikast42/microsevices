package eu.amova.cloud.platform.service.security.configuration;

import eu.amova.cloud.platform.service.security.dao.ClientDetailsRepository;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author: vuru
 * Date: 19.04.2017
 * Time: 08:36
 */

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Log log;


    @Autowired
    private ClientDetailsRepository clientDetailsRepository;

//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        AuthenticationManager authenticationManager = super.authenticationManagerBean();
//        return authenticationManager;
//    }

    //    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .exceptionHandling()
//                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
//                .and()
//                .authorizeRequests()
//                .antMatchers("/**").authenticated()
//                .and()
//                .httpBasic();
//    }
//
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(clientDetailsRepository);
//        auth.inMemoryAuthentication()
//                .withUser("reader")
//                .password("reader")
//                .authorities("FOO_READ")
//                .and()
//                .withUser("writer")
//                .password("writer")
//                .authorities("FOO_READ", "FOO_WRITE");
    }
}