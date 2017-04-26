//package eu.amova.cloud.platform.service.security.persistence;
//
////create table oauth_approvals (
////        userId VARCHAR(256),
////        clientId VARCHAR(256),
////        scope VARCHAR(256),
////        status VARCHAR(10),
////        expiresAt TIMESTAMP,
////        lastModifiedAt TIMESTAMP
////        );
//
//import javax.persistence.*;
//import java.util.Date;
//
///**
// * @author: vuru
// * Date: 26.04.2017
// * Time: 09:22
// */
//@Entity
//@Table(name = "oauth_approvals")
//public class OAuthApprovals extends EntityBase {
//
//    @Column(name = "userId", length = 256)
//    private String userId;
//
//    @Column(name = "clientId", length = 256)
//    private String clientId;
//
//    @Column(name = "scope", length = 256)
//    private String scope;
//
//    @Column(name = "status", length = 10)
//    private String status;
//
//    @Column(name = "expiresAt")
//    private Date expiresAt;
//
//    @Column(name = "lastModifiedAt")
//    private Date lastModifiedAt;
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getClientId() {
//        return clientId;
//    }
//
//    public void setClientId(String clientId) {
//        this.clientId = clientId;
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
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public Date getExpiresAt() {
//        return expiresAt;
//    }
//
//    public void setExpiresAt(Date expiresAt) {
//        this.expiresAt = expiresAt;
//    }
//
//    public Date getLastModifiedAt() {
//        return lastModifiedAt;
//    }
//
//    public void setLastModifiedAt(Date lastModifiedAt) {
//        this.lastModifiedAt = lastModifiedAt;
//    }
//}
