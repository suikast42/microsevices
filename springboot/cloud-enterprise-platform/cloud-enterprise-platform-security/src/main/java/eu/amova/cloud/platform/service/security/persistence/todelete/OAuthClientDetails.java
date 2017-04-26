//package eu.amova.cloud.platform.service.security.persistence;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//// OAuth2 defined Mapping
////create table oauth_client_details (
////        client_id VARCHAR(256) PRIMARY KEY,
////        resource_ids VARCHAR(256),
////        client_secret VARCHAR(256),
////        scope VARCHAR(256),
////        authorized_grant_types VARCHAR(256),
////        web_server_redirect_uri VARCHAR(256),
////        authorities VARCHAR(256),
////        access_token_validity INTEGER,
////        refresh_token_validity INTEGER,
////        additional_information VARCHAR(4096),
////        autoapprove VARCHAR(256)
////        );
//
///**
// * @author: vuru
// * Date: 26.04.2017
// * Time: 08:59
// */
//@Entity
//@Table(name = "oauth_client_details")
//public class OAuthClientDetails extends EntityBase{
//
//    @Column(name = "client_id", length = 256)
//    private String client_id;
//
//    @Column(name = "resource_ids", length = 256)
//    private String resource_ids;
//
//    @Column(name = "client_secret", length = 256)
//    private String client_secret;
//
//    @Column(name = "scope", length = 256)
//    private String scope;
//
//    @Column(name = "authorized_grant_types", length = 256)
//    private String authorized_grant_types;
//
//    @Column(name = "web_server_redirect_uri", length = 256)
//    private String web_server_redirect_uri;
//
//    @Column(name = "authorities", length = 256)
//    private String authorities;
//
//    @Column(name = "access_token_validity")
//    private int access_token_validity;
//
//    @Column(name = "refresh_token_validity")
//    private int refresh_token_validity;
//
//    @Column(name = "additional_information", length = 256)
//    private String additional_information;
//
//    @Column(name = "autoapprove", length = 256)
//    private String autoapprove;
//
//    public String getClient_id() {
//        return client_id;
//    }
//
//    public void setClient_id(String client_id) {
//        this.client_id = client_id;
//    }
//
//    public String getResource_ids() {
//        return resource_ids;
//    }
//
//    public void setResource_ids(String resource_ids) {
//        this.resource_ids = resource_ids;
//    }
//
//    public String getClient_secret() {
//        return client_secret;
//    }
//
//    public void setClient_secret(String client_secret) {
//        this.client_secret = client_secret;
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
//    public String getAuthorized_grant_types() {
//        return authorized_grant_types;
//    }
//
//    public void setAuthorized_grant_types(String authorized_grant_types) {
//        this.authorized_grant_types = authorized_grant_types;
//    }
//
//    public String getWeb_server_redirect_uri() {
//        return web_server_redirect_uri;
//    }
//
//    public void setWeb_server_redirect_uri(String web_server_redirect_uri) {
//        this.web_server_redirect_uri = web_server_redirect_uri;
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
//    public int getAccess_token_validity() {
//        return access_token_validity;
//    }
//
//    public void setAccess_token_validity(int access_token_validity) {
//        this.access_token_validity = access_token_validity;
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
//    public String getAdditional_information() {
//        return additional_information;
//    }
//
//    public void setAdditional_information(String additional_information) {
//        this.additional_information = additional_information;
//    }
//
//    public String getAutoapprove() {
//        return autoapprove;
//    }
//
//    public void setAutoapprove(String autoapprove) {
//        this.autoapprove = autoapprove;
//    }
//}
