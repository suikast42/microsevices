//package eu.amova.cloud.platform.service.security.persistence;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
////
////create table oauth_client_token (
////        token_id VARCHAR(256),
////        token LONGVARBINARY,
////        authentication_id VARCHAR(256) PRIMARY KEY,
////        user_name VARCHAR(256),
////        client_id VARCHAR(256)
////        );
///**
// * @author: vuru
// * Date: 26.04.2017
// * Time: 09:11
// */
//@Entity
//@Table(name = "oauth_client_token")
//public class OAuthClientToken {
//
//    @Id
//    @Column(name = "authentication_id", length = 256)
//    private String id;
//
//    @Column(name = "token_id", length = 256)
//    private String token_id;
//
//    @Column(name = "token", length = 256)
//    private Long token;
//
//    @Column(name = "user_name", length = 256)
//    private Long user_name;
//
//    @Column(name = "client_id", length = 256)
//    private long client_id;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof OAuthClientToken)) return false;
//
//        OAuthClientToken that = (OAuthClientToken) o;
//
//        return id != null ? id.equals(that.id) : that.id == null;
//    }
//
//    @Override
//    public int hashCode() {
//        return id != null ? id.hashCode() : 0;
//    }
//
//    @Override
//    public String toString() {
//        return "OAuthClientToken{" +
//                "id='" + id + '\'' +
//                ", token_id='" + token_id + '\'' +
//                ", token=" + token +
//                ", user_name=" + user_name +
//                ", client_id=" + client_id +
//                '}';
//    }
//}
