package eu.amova.cloud.platform.service.security.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author: vuru
 * Date: 05.05.2017
 * Time: 10:45
 */

@Entity
@Table(name = "oauth_approvals")
public class OAuth2Aprovals extends EntityBase{

//    userId VARCHAR(256),
//    clientId VARCHAR(256),
//    scope VARCHAR(256),
//    status VARCHAR(10),
//    expiresAt TIMESTAMP,
//    lastModifiedAt TIMESTAMP

    @Column(length = 256)
    private String   userId;

    @Column(length = 256)
    private String   clientId;

    @Column(length = 256)
    private String   scope;

    @Column(length = 10)
    private String   status;
    private LocalDateTime expiresAt;
    private LocalDateTime lastModifiedAt;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public LocalDateTime getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(LocalDateTime lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    @Override
    public String toString() {
        return "OAuth2Aprovals{ " + super.toString() +
                " userId='" + userId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", scope='" + scope + '\'' +
                ", status='" + status + '\'' +
                ", expiresAt=" + expiresAt +
                ", lastModifiedAt=" + lastModifiedAt +
                '}';
    }
}
