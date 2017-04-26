//package eu.amova.cloud.platform.service.security.persistence;
//
////create table oauth_refresh_token (
////        token_id VARCHAR(256),
////        token LONGVARBINARY,
////        authentication LONGVARBINARY
////        );
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
///**
// * @author: vuru
// * Date: 26.04.2017
// * Time: 09:18
// */
//
//@Entity
//@Table(name = "oauth_refresh_token")
//public class OAuthRefreshToken extends EntityBase {
//
//    @Column(name = "token_id", length = 256)
//    private String token_id;
//
//    @Column(name = "token", length = 256)
//    private long token;
//
//    @Column(name = "authentication", length = 256)
//    private long authentication;
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
//    public long getAuthentication() {
//        return authentication;
//    }
//
//    public void setAuthentication(long authentication) {
//        this.authentication = authentication;
//    }
//}
