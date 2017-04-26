//package eu.amova.cloud.platform.service.security.persistence;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//
////create table ClientDetails (
////        appId VARCHAR(256) PRIMARY KEY,
////        resourceIds VARCHAR(256),
////        appSecret VARCHAR(256),
////        scope VARCHAR(256),
////        grantTypes VARCHAR(256),
////        redirectUrl VARCHAR(256),
////        authorities VARCHAR(256),
////        access_token_validity INTEGER,
////        refresh_token_validity INTEGER,
////        additionalInformation VARCHAR(4096),
////        autoApproveScopes VARCHAR(256)
////        );
//
///**
// * @author: vuru
// * Date: 26.04.2017
// * Time: 09:25
// */
//
//@Entity
//@Table(name = "ClientDetails")
//public class ClientDetails extends EntityBase{
//
//    @Column(name = "appId", length = 256)
//    private String appId;
//
//    @Column(name = "resourceIds", length = 256)
//    private String resourceIds;
//
//    @Column(name = "appSecret", length = 256)
//    private String appSecret;
//
//    @Column(name = "scope", length = 256)
//    private String scope;
//
//    @Column(name = "grantTypes", length = 256)
//    private String grantTypes;
//
//    @Column(name = "redirectUrl", length = 256)
//    private String redirectUrl;
//
//    @Column(name = "authorities", length = 256)
//    private String authorities;
//
//    @Column(name = "refresh_token_validity")
//    private int refresh_token_validity;
//
//    @Column(name = "access_token_validity")
//    private int access_token_validity;
//
//    @Column(name = "additionalInformation", length = 4096)
//    private String additionalInformation;
//
//    @Column(name = "autoApproveScopes", length = 256)
//    private String autoApproveScopes;
//
//    public String getAppId() {
//        return appId;
//    }
//
//    public void setAppId(String appId) {
//        this.appId = appId;
//    }
//
//    public String getResourceIds() {
//        return resourceIds;
//    }
//
//    public void setResourceIds(String resourceIds) {
//        this.resourceIds = resourceIds;
//    }
//
//    public String getAppSecret() {
//        return appSecret;
//    }
//
//    public void setAppSecret(String appSecret) {
//        this.appSecret = appSecret;
//    }
//
//    public String getScope() {
//        return scope;
//    }
//
//    public void setScope(String scope) {
//        this.scope = scope;
//    }
//
//    public String getGrantTypes() {
//        return grantTypes;
//    }
//
//    public void setGrantTypes(String grantTypes) {
//        this.grantTypes = grantTypes;
//    }
//
//    public String getRedirectUrl() {
//        return redirectUrl;
//    }
//
//    public void setRedirectUrl(String redirectUrl) {
//        this.redirectUrl = redirectUrl;
//    }
//
//    public String getAuthorities() {
//        return authorities;
//    }
//
//    public void setAuthorities(String authorities) {
//        this.authorities = authorities;
//    }
//
//    public int getRefresh_token_validity() {
//        return refresh_token_validity;
//    }
//
//    public void setRefresh_token_validity(int refresh_token_validity) {
//        this.refresh_token_validity = refresh_token_validity;
//    }
//
//    public int getAccess_token_validity() {
//        return access_token_validity;
//    }
//
//    public void setAccess_token_validity(int access_token_validity) {
//        this.access_token_validity = access_token_validity;
//    }
//
//    public String getAdditionalInformation() {
//        return additionalInformation;
//    }
//
//    public void setAdditionalInformation(String additionalInformation) {
//        this.additionalInformation = additionalInformation;
//    }
//
//    public String getAutoApproveScopes() {
//        return autoApproveScopes;
//    }
//
//    public void setAutoApproveScopes(String autoApproveScopes) {
//        this.autoApproveScopes = autoApproveScopes;
//    }
//
//
//}
