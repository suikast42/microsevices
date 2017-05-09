package eu.amova.cloud.platform.service.security.persistence;

import javax.persistence.*;

/**
 * @author: vuru
 * Date: 05.05.2017
 * Time: 11:40
 */
@Entity
@Table(name = "oauth_code")
public class OAuth2Code {
//    code VARCHAR(256),
//    authentication BLOB

    @Id
    @Column(length = 256)
    private String  code;

    @Column
    @Lob
    private byte[]  authentication;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }
}
