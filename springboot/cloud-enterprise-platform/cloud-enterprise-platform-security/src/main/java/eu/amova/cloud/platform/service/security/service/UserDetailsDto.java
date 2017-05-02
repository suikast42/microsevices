package eu.amova.cloud.platform.service.security.service;

import org.springframework.security.core.userdetails.User;

/**
 * @author: vuru
 * Date: 02.05.2017
 * Time: 15:52
 */
public class UserDetailsDto extends User {
    public UserDetailsDto(eu.amova.cloud.platform.service.security.persistence.User user) {
        super(user.getLogin(), user.getPassword(), user.isEnabled(), true, true, true, user.getAuthorities());
    }
}
