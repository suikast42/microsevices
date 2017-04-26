package eu.amova.cloud.platform.service.security.dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: vuru
 * Date: 26.04.2017
 * Time: 10:13
 */
@Repository
@Transactional
public class ClientDetailsRepository implements ClientDetailsService,ClientRegistrationService,UserDetailsService {

    @PersistenceContext
    private EntityManager  em;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority>  auths = new ArrayList<>();
        auths.add(new SimpleGrantedAuthority("role1"));
        return new User(username,"pass1",auths) ;
//        throw new UsernameNotFoundException("Fake for "+username);
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Foo");
        BaseClientDetails baseClientDetails = new BaseClientDetails();
        baseClientDetails.setClientId(clientId);
        baseClientDetails.setAuthorizedGrantTypes(strings);
        return baseClientDetails;
//       throw new  ClientRegistrationException("Fake for "+clientId) ;
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


}
