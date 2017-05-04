//package eu.amova.cloud.platform.service.security.service;
//
//import eu.amova.cloud.platform.service.security.dao.UserRepository;
//import eu.amova.cloud.platform.service.security.persistence.User;
//import org.apache.commons.logging.Log;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.oauth2.integration.*;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
///**
// * @author: vuru
// * Date: 26.04.2017
// * Time: 10:13
// */
//
//@Service
//@Repository
//@Transactional
//public class ClientDetailsIntegrationService implements ClientDetailsService, ClientRegistrationService, UserDetailsService {
//
//    @Autowired
//    private Log logger;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private HttpServletRequest request;
//
//    // from UserDetailsService
//    @Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        try {
//            User user = userRepository.findByLogin(username);
//            if (user == null) {
//                throw new UsernameNotFoundException("No user found with username: " + username);
//            }
//            return new UserDetailsDto(user);
//        } catch (final Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
////        try {
////            User user = userRepository.findByLogin(clientId);
////            if (user == null) {
////                throw new ClientRegistrationException("No user found with username: " + clientId);
////            }
////            return new OAuth2ClientDetails(user);
////        } catch (final Exception e) {
////            throw new RuntimeException(e);
////        }
//        logger.error("loadClientByClientId not implemented");
//        throw new ClientRegistrationException("loadClientByClientId not implemented");
//    }
//
//    @Override
//    public void addClientDetails(ClientDetails clientDetails) throws ClientAlreadyExistsException {
//        logger.error("addClientDetails not implemented");
//        throw new ClientAlreadyExistsException("Fake for " + clientDetails);
//    }
//
//    @Override
//    public void updateClientDetails(ClientDetails clientDetails) throws NoSuchClientException {
//        logger.error("updateClientDetails not implemented");
//        throw new NoSuchClientException("Fake for " + clientDetails);
//    }
//
//    @Override
//    public void updateClientSecret(String clientId, String secret) throws NoSuchClientException {
//        logger.error("updateClientSecret not implemented");
//        throw new NoSuchClientException("Fake for " + clientId);
//    }
//
//    @Override
//    public void removeClientDetails(String clientId) throws NoSuchClientException {
//        logger.error("removeClientDetails not implemented");
//        throw new NoSuchClientException("Fake for " + clientId);
//    }
//
//    @Override
//    public List<ClientDetails> listClientDetails() {
//        logger.error("listClientDetails not implemented");
//        throw new RuntimeException("Fake");
//    }
//
//
////    private final Collection<? extends GrantedAuthority> getAuthorities(final Collection<Role> roles) {
////        return getGrantedAuthorities(getPrivileges(roles));
////    }
//
////    // Utility methods b
////    private final List<String> getPrivileges(final Collection<Role> roles) {
////        final List<String> privileges = new ArrayList<String>();
////        final List<Privilege> collection = new ArrayList<Privilege>();
////        for (final Role role : roles) {
////            collection.addAll(role.getPrivileges());
////        }
////        for (final Privilege item : collection) {
////            privileges.add(item.getName());
////        }
////
////        return privileges;
////    }
////
////    private final List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
////        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
////        for (final String privilege : privileges) {
////            authorities.add(new SimpleGrantedAuthority(privilege));
////        }
////        return authorities;
////    }
////
////    private final String getClientIP() {
////        final String xfHeader = request.getHeader("X-Forwarded-For");
////        if (xfHeader == null) {
////            return request.getRemoteAddr();
////        }
////        return xfHeader.split(",")[0];
////    }
//
//}
