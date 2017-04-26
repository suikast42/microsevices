//package eu.amova.cloud.platform.service.security.persistence;
//
////create table oauth_access_token (
////        token_id VARCHAR(256),
////        token LONGVARBINARY,
////        authentication_id VARCHAR(256) PRIMARY KEY,
////        user_name VARCHAR(256),
////        client_id VARCHAR(256),
////        authentication LONGVARBINARY,
////        refresh_token VARCHAR(256)
////        );
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
///**
// * @author: vuru
// * Date: 26.04.2017
// * Time: 09:14
// */
//
//@Entity
//@Table(name = "oauth_access_token")
//public class OAuthAcessToken extends EntityBase {
//
//    @Column(name = "authentication_id", length = 256)
//    private String authentication_id;
//
//    @Column(name = "token_id", length = 256)
//    private String token_id;
//
//    @Column(name = "token", length = 256)
//    private long token;
//
//    @Column(name = "user_name", length = 256)
//    private String user_name;
//
//    @Column(name = "client_id", length = 256)
//    private String client_id;
//
//    @Column(name = "authentication", length = 256)
//    private long authentication;
//
//    @Column(name = "refresh_token", length = 256)
//    private String refresh_token;
//
//    public String getAuthentication_id() {
//        return authentication_id;
//    }
//
//    public void setAuthentication_id(String authentication_id) {
//        this.authentication_id = authentication_id;
//    }
//
//    public String getToken_id() {
//        return token_id;
//    }
//
//    public void setToken_id(String token_id) {
//        this.token_id = token_id;
//    }
//
//    public long getToken() {
//        return token;
//    }
//
//    public void setToken(long token) {
//        this.token = token;
//    }
//
//    public String getUser_name() {
//        return user_name;
//    }
//
//    public void setUser_name(String user_name) {
//        this.user_name = user_name;
//    }
//
//    public String getClient_id() {
//        return client_id;
//    }
//
//    public void setClient_id(String client_id) {
//        this.client_id = client_id;
//    }
//
//    public long getAuthentication() {
//        return authentication;
//    }
//
//    public void setAuthentication(long authentication) {
//        this.authentication = authentication;
//    }
//
//    public String getRefresh_token() {
//        return refresh_token;
//    }
//
//    public void setRefresh_token(String refresh_token) {
//        this.refresh_token = refresh_token;
//    }
//}
