package eu.amova.cloud.platform.service.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableConfigServer
public class CloudEnterprisePlatformConfigurationApplication {


	public static void main(String[] args) {
		SpringApplication.run(CloudEnterprisePlatformConfigurationApplication.class, args);
	}
}
