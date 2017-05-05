package eu.amova.cloud.platform.service.security.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author: vuru
 * Date: 05.05.2017
 * Time: 11:22
 */
@Entity
@Table(name = "oauth_access_token")
public class OAuth2AccessToken extends EntityBase{
//    token_id VARCHAR(256),
//    token LONGVARBINARY,
//    authentication_id VARCHAR(256) PRIMARY KEY,
//    user_name VARCHAR(256),
//    client_id VARCHAR(256),
//    authentication LONGVARBINARY,
//    refresh_token VARCHAR(256)

    @Column(name = "token_id",length = 256)
    private String tokenId ;

    @Column
    @Lob
    private byte[] token ;

    @Column(name = "authentication_id",length = 256,unique = true)
    private String authenticationId ;

    @Column(name = "user_name",length = 256)
    private String userMame ;

    @Column(name = "client_id",length = 256)
    private String clientId ;

    @Column
    @Lob
    private  byte[] authentication ;


    @Column(name = "refresh_token",length = 256)
    private String refreshToken ;

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public byte[] getToken() {
        return token;
    }

    public void setToken(byte[] token) {
        this.token = token;
    }

    public String getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

    public String getUserMame() {
        return userMame;
    }

    public void setUserMame(String userMame) {
        this.userMame = userMame;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
