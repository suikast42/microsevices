package eu.amova.cloud.platform.service.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties(value = {ConfigProperties.class})
public class CloudEnterprisePlatformMessagingApplication {


    @Autowired
    private ConfigProperties props;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CloudEnterprisePlatformMessagingApplication.class, args);
    }
//
//	@Value("${spring.application.name}")
//	private String appName ;


//	@Bean//(initMethod = "start", destroyMethod = "stop")
//	public BrokerService brokerService() throws Exception {
//		BrokerService brokerService = new BrokerService();
//		brokerService.setPersistent(false);
//		brokerService.setUseJmx(true);
//		//brokerService.addConnector("vm://localhost:0");
//		String serverUrl = MessageFormat.format("tcp://{0}:{1}", props.getHost(), props.getPort());
//		brokerService.addConnector(serverUrl);
//		brokerService.setBrokerName(appName);
//		brokerService.setUseLoggingForShutdownErrors(true);
//		brokerService.setUseShutdownHook(false);
//		return brokerService;
//	}


}
