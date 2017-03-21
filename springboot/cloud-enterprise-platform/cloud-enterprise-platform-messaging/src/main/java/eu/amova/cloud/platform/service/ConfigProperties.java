package eu.amova.cloud.platform.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: vuru
 * Date: 20.03.2017
 * Time: 08:41
 */
@ConfigurationProperties(prefix="messaging")
public class ConfigProperties {

    private String host;
    private String port;

    public String getPort() {
        if(this.port ==  null) {
            return "9003";
        }
        return port;
    }

    public void setPort(String port) {
      
        this.port = port;
    }

    public String getHost() {
        if(this.host == null) {
            try {
                return InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                
            }
        }
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
