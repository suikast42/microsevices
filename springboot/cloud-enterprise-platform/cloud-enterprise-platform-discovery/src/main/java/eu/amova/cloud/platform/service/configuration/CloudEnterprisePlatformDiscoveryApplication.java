package eu.amova.cloud.platform.service.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableEurekaServer
@EnableDiscoveryClient
public class CloudEnterprisePlatformDiscoveryApplication {


	public static void main(String[] args) {
		SpringApplication.run(CloudEnterprisePlatformDiscoveryApplication.class, args);
	}
}
