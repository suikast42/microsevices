package eu.amova.cloud.platform.service.security.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author: vuru
 * Date: 05.05.2017
 * Time: 10:12
 */
@Entity
@Table(name = "oauth_client_details")
public class OAuth2ClientDetails  extends EntityBase{
//    client_id VARCHAR(256) PRIMARY KEY,
//    resource_ids VARCHAR(256),
//    client_secret VARCHAR(256),
//    scope VARCHAR(256),
//    authorized_grant_types VARCHAR(256),
//    web_server_redirect_uri VARCHAR(256),
//    authorities VARCHAR(256),
//    access_token_validity INTEGER,
//    refresh_token_validity INTEGER,
//    additional_information VARCHAR(4096),
//    autoapprove VARCHAR(256)
    @Column(name = "client_id",unique = true,length = 256)
    @NotNull
    private String clientId;

    @Column(name = "resource_ids",length = 256)
    private String resourceIds;

    @Column (name = "client_secret",length = 256)
    private String clientSecret;

    @Column (length = 256)
    private String scope;

    @Column(name = "authorized_grant_types",length = 256)
    private String authorizedGrantTypes;

    @Column (name ="web_server_redirect_uri",length = 256 )
    private String webServerRedirectUri;

    @Column (length = 256)
    private String authorities;

    @Column(name = "access_token_validity")
    private int accessTokenValidity = 3600;

    @Column (name = "refresh_token_validity")
    private int refreshTokenValidity=2592000;

    @Column(name = "additional_information",length = 4096)
    private String additionalInformation;

    @Column (length = 256)
    private String autoapprove;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public int getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(int accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public int getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(int refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAutoapprove() {
        return autoapprove;
    }

    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }

    @Override
    public String toString() {
        return "OAuth2ClientDetails{ " + super.toString()+
                " clientId='" + clientId + '\'' +
                ", resourceIds='" + resourceIds + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", scope='" + scope + '\'' +
                ", authorizedGrantTypes='" + authorizedGrantTypes + '\'' +
                ", webServerRedirectUri='" + webServerRedirectUri + '\'' +
                ", authorities='" + authorities + '\'' +
                ", accessTokenValidity=" + accessTokenValidity +
                ", refreshTokenValidity=" + refreshTokenValidity +
                ", additionalInformation='" + additionalInformation + '\'' +
                ", autoapprove='" + autoapprove + '\'' +
                '}';
    }
}
