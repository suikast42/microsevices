package eu.amova.cloud.platform.service.security.persistence;

import javax.persistence.*;

/**
 * @author: vuru
 * Date: 05.05.2017
 * Time: 11:08
 */
@Entity
@Table(name = "oauth_client_token")
public class OAuth2ClientToken {

//    token_id VARCHAR(256),
//    token LONGVARBINARY,
//    authentication_id VARCHAR(256) PRIMARY KEY,
//    user_name VARCHAR(256),
//    client_id VARCHAR(256)

    @Column(length = 256,name = "token_id")
    private String  tokenId;

    @Column
    @Lob
    private byte[]  token;

    @Id
    @Column(length = 256,name = "authentication_id",unique = true)
    private String  authenticationId;

    @Column(length = 256,name = "user_name")
    private String  userName;

    @Column(length = 256,name = "client_id")
    private String  clientId;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


}
