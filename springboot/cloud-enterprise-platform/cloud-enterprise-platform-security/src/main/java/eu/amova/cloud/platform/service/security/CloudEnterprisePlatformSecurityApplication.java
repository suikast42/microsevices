package eu.amova.cloud.platform.service.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
//@EnableResourceServer
public class CloudEnterprisePlatformSecurityApplication {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(CloudEnterprisePlatformSecurityApplication.class, args);
    }

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



    @Target({TYPE, METHOD, PARAMETER, FIELD})
    @Retention(RUNTIME)
    @Documented
    public @interface NamedLogger {

        String loggername() default "NamedLogger";
    }
}
