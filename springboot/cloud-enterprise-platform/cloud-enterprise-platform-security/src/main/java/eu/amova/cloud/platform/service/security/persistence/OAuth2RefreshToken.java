package eu.amova.cloud.platform.service.security.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author: vuru
 * Date: 05.05.2017
 * Time: 11:26
 */
@Entity
@Table(name = "oauth_refresh_token")
public class OAuth2RefreshToken extends EntityBase{
//    token_id VARCHAR(256),
//    token BLOB,
//    authentication BLOB

    @Column(length = 256,name = "token_id")
    private String  tokenId;

    @Column
    @Lob
    private byte[]  token;

    @Column
    @Lob
    private byte[]  authentication;

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

    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }
}
