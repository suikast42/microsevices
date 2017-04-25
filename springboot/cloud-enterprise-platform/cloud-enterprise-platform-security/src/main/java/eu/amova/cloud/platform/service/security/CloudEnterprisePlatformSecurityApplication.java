package eu.amova.cloud.platform.service.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAuthorizationServer
//@EnableResourceServer
public class CloudEnterprisePlatformSecurityApplication {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(CloudEnterprisePlatformSecurityApplication.class, args);

    }


}
