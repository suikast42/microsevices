//package eu.amova.cloud.platform.service.security.service;
//
//import eu.amova.cloud.platform.service.security.persistence.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.integration.ClientDetails;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
///**
// * @author: vuru
// * Date: 27.04.2017
// * Time: 16:51
// */
//public class OAuth2ClientDetails implements ClientDetails {
//
//    private final User user;
//
//    public OAuth2ClientDetails(User user) {
//        this.user = user;
//    }
//
//    @Override
//    public String getClientId() {
//        return user.getLogin();
//    }
//
//    @Override
//    public Set<String> getResourceIds() {
//        return new HashSet<>();
//    }
//
//    @Override
//    public boolean isSecretRequired() {
//        return true;
//    }
//
//    @Override
//    public String getClientSecret() {
//        return user.getSecret();
//    }
//
//    @Override
//    public boolean isScoped() {
//        return true;
//    }
//
//    @Override
//    public Set<String> getScope() {
//        return new HashSet<>();
//    }
//
//    @Override
//    public Set<String> getAuthorizedGrantTypes() {
//        Set<String> result = new HashSet<>();
//        user.getRoles().forEach(role ->{
//            role.getPrivileges().forEach(priv->result.add(priv.getName()));
//        });
//        return result;
//    }
//
//    @Override
//    public Set<String> getRegisteredRedirectUri() {
//     return new HashSet<>();
//    }
//
//    @Override
//    public Collection<GrantedAuthority> getAuthorities() {
//        return user.getRoles().parallelStream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
//    }
//
//    @Override
//    public Integer getAccessTokenValiditySeconds() {
//        return user.getAccessTokenValiditySeconds();
//    }
//
//    @Override
//    public Integer getRefreshTokenValiditySeconds() {
//        return user.getRefreshTokenValiditySecond();
//    }
//
//    @Override
//    public boolean isAutoApprove(String scope) {
//        return false;
//    }
//
//    @Override
//    public Map<String, Object> getAdditionalInformation() {
//        return new HashMap<>();
//    }
//}
