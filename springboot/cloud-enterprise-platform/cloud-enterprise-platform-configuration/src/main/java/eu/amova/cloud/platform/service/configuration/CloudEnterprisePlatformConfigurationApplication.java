package eu.amova.cloud.platform.service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableConfigServer
public class CloudEnterprisePlatformConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudEnterprisePlatformConfigurationApplication.class, args);
	}

//	@Autowired
//	private EurekaInstanceConfigBean conf;
//	@PostConstruct
//	private void init( ){
//		if(conf.isPreferIpAddress()) {
//			// worarround for get the hosname instaed of ip adress here.
//			conf.setPreferIpAddress(false);
//			String currentInstanceId = conf.getInstanceId();
//			conf.setInstanceId(currentInstanceId.replace(conf.getHostname(),conf.getIpAddress()));
//			conf.setPreferIpAddress(true);
//		}
//
//	}
}
