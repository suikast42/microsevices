package eu.amova.cloud.platform.service.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@ComponentScan(basePackages = "eu.amova")
@SpringBootApplication
@EnableTransactionManagement
@EnableAutoConfiguration
@EnableJpaRepositories
public class CloudEnterprisePlatformSecurityApplication {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(CloudEnterprisePlatformSecurityApplication.class, args);
    }

    @Target({TYPE, METHOD, PARAMETER, FIELD})
    @Retention(RUNTIME)
    @Documented
    public @interface NamedLogger {

        String loggername() default "NamedLogger";
    }

    /////////////////////////// Producers ////////////////////////////////
    /// Define all common producers here for avoid cycles        /////////
    @Bean
    @Lazy
    public Log getLogger(InjectionPoint injectionPoint) {
        Log logger;
        if (injectionPoint.getAnnotatedElement().isAnnotationPresent(NamedLogger.class)) {
            NamedLogger annotation = injectionPoint.getAnnotatedElement().getAnnotation(NamedLogger.class);
            logger = LogFactory.getLog(annotation.loggername());
        } else {
            logger = LogFactory.getLog(injectionPoint.getMember().getDeclaringClass().getName());
        }
        return logger;
    }

    /***
     * Make the default datasource injectable. 
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @Lazy
    public DataSource dataSource() {
        return  DataSourceBuilder.create().build();
    }


    @Bean
    @Lazy
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(7);
    }


    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }


}
