package eu.amova.cloud.platform.service.security.service;

import eu.amova.cloud.platform.service.security.dao.UserRepository;
import eu.amova.cloud.platform.service.security.persistence.Privilege;
import eu.amova.cloud.platform.service.security.persistence.Role;
import eu.amova.cloud.platform.service.security.persistence.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: vuru
 * Date: 26.04.2017
 * Time: 10:13
 */

@Service
@Repository
@Transactional
public class ClientDetailsIntegrationService implements ClientDetailsService,ClientRegistrationService,UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest request;

    // from UserDetailsService
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepository.findByLogin(username);
            if (user == null) {
                throw new UsernameNotFoundException("No user found with username: " + username);
            }
            return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), user.isEnabled(), true, true, true, getAuthorities(user.getRoles()));
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
       throw new  ClientRegistrationException("Fake for "+clientId) ;
    }

    @Override
    public void addClientDetails(ClientDetails clientDetails) throws ClientAlreadyExistsException {
        throw new  ClientAlreadyExistsException("Fake for "+clientDetails) ;
    }

    @Override
    public void updateClientDetails(ClientDetails clientDetails) throws NoSuchClientException {
        throw new  NoSuchClientException("Fake for "+clientDetails) ;
    }

    @Override
    public void updateClientSecret(String clientId, String secret) throws NoSuchClientException {
        throw new  NoSuchClientException("Fake for "+clientId) ;
    }

    @Override
    public void removeClientDetails(String clientId) throws NoSuchClientException {
        throw new  NoSuchClientException("Fake for "+clientId) ;
    }

    @Override
    public List<ClientDetails> listClientDetails() {
        throw new  RuntimeException("Fake") ;
    }


    private final Collection<? extends GrantedAuthority> getAuthorities(final Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    // Utility methods b
    private final List<String> getPrivileges(final Collection<Role> roles) {
        final List<String> privileges = new ArrayList<String>();
        final List<Privilege> collection = new ArrayList<Privilege>();
        for (final Role role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (final Privilege item : collection) {
            privileges.add(item.getName());
        }

        return privileges;
    }

    private final List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (final String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    private final String getClientIP() {
        final String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }

}
