package eu.amova.cloud.platform.service.security.spring.integration;

import eu.amova.cloud.platform.service.security.dao.UserRepository;
import eu.amova.cloud.platform.service.security.persistence.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.event.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

/**
 * @author: vuru
 * Date: 04.05.2017
 * Time: 09:53
 */
@Service("userDetailsService")
@Transactional
public class UserDetailsServiceDelegate implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Autowired
    private HttpServletRequest request;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final String ip = getClientIP();
        System.err.println("loadUserByUsername "+username);
        if (loginAttemptService.isBlocked(ip)) {
            throw new RuntimeException(MessageFormat.format("The ip {0} is blocked. Too many login attempts {1}",ip,loginAttemptService.getMAX_ATTEMPT()));
        }

        try {
            User user = userRepository.findByLogin(username);
            if (user == null) {
                throw new UsernameNotFoundException("No user found with username: " + username);
            }
            if(!user.isEnabled()) {
                throw new RuntimeException(MessageFormat.format("The user {0} is blocked. Please contact admin",username));
            }
            return new UserDetailsDto(user);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    private final String getClientIP() {
        final String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}
