//package eu.amova.cloud.platform.service.security.persistence;
//
////create table oauth_code (
////        code VARCHAR(256),
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
// * Time: 09:20
// */
//
//@Entity
//@Table(name = "oauth_code")
//public class OAuthCode extends EntityBase{
//
//    @Column(name = "code", length = 256)
//    private String token_id;
//
//    @Column(name = "authentication", length = 256)
//    private long authentication;
//
//
//    public String getToken_id() {
//        return token_id;
//    }
//
//    public void setToken_id(String token_id) {
//        this.token_id = token_id;
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
