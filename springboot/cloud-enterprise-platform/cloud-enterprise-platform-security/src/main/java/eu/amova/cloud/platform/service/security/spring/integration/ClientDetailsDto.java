package eu.amova.cloud.platform.service.security.spring.integration;

import eu.amova.cloud.platform.service.security.persistence.OAuth2ClientDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;

/**
 * @author: vuru
 * Date: 09.05.2017
 * Time: 16:55
 */
public class ClientDetailsDto implements ClientDetails {

    private OAuth2ClientDetails clientDetails;

    public ClientDetailsDto(OAuth2ClientDetails clientDetails) {
        this.clientDetails = clientDetails;
    }

    @Override
    public String getClientId() {
        return clientDetails.getClientId();
    }

    @Override
    public Set<String> getResourceIds() {
        if (clientDetails.getResourceIds() != null) {
            return new HashSet<>(Arrays.asList(clientDetails.getResourceIds().split(",")));
        }
        return new HashSet<>();
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return clientDetails.getClientSecret();
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        if (clientDetails.getScope() != null) {
            return new HashSet<>(Arrays.asList(clientDetails.getScope().split(",")));
        }
        return new HashSet<>();
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        if (clientDetails.getAuthorizedGrantTypes() != null) {
            return new HashSet<>(Arrays.asList(clientDetails.getAuthorizedGrantTypes().split(",")));
        }
        return new HashSet<>();
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        if (clientDetails.getWebServerRedirectUri() != null) {
            return new HashSet<>(Arrays.asList(clientDetails.getWebServerRedirectUri().split(",")));
        }
        return new HashSet<>();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        if (clientDetails.getAuthorizedGrantTypes() != null) {
            HashSet<GrantedAuthority> result = new HashSet<>();
            for (String grantType : clientDetails.getAuthorizedGrantTypes().split(",")) {
                result.add(new SimpleGrantedAuthority(grantType));
            }
            return result;
        }
        return new HashSet<>();
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return clientDetails.getAccessTokenValidity();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return clientDetails.getRefreshTokenValidity();
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return true;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return new HashMap<>();
    }
}
