package eu.amova.cloud.platform.service.security.persistence;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * @author: vuru
 * Date: 26.04.2017
 * Time: 15:26
 */
@Entity
@Table(name = "Users")
@NamedEntityGraphs({
        @NamedEntityGraph(name = User.EG_WITH_ROLES_AND_PRIVS,
                attributeNodes = @NamedAttributeNode(value = "roles", subgraph = "roles"),
                subgraphs = @NamedSubgraph(name = "roles", attributeNodes = @NamedAttributeNode("privileges")))
})
public class User extends EntityBase {

    public static final String EG_WITH_ROLES_AND_PRIVS = "User.With.Roles.And.Privs";

    @Column(length = 255)
    @NotNull
    private String login;
    @Column
    @NotNull
    private Locale locale;
    @Column(length = 255)
    @NotNull
    private String firstName;
    @Column(length = 255)
    @NotNull
    private String lastName;
    @Column
    @NotNull
    @Email
    private String email;
    @Column(length = 60)
    @NotNull
    private String password;
    @Column
    private boolean enabled;
    @Column
    private String secret;
    @Column
    private int accessTokenValiditySeconds = 60 * 5;
    @Column
    private int refreshTokenValiditySecond = 60 * 5;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
        super();
        this.enabled = false;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(int accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    public int getRefreshTokenValiditySecond() {
        return refreshTokenValiditySecond;
    }

    public void setRefreshTokenValiditySecond(int refreshTokenValiditySecond) {
        this.refreshTokenValiditySecond = refreshTokenValiditySecond;
    }

    @Override
    public String toString() {
        return "User{ " + super.toString() +
                " login='" + login + '\'' +
                ", locale=" + locale +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", secret='" + secret + '\'' +
                '}';
    }

    // Utils
    public final Collection<? extends GrantedAuthority> getAuthorities() {
        Set<String> privs = new HashSet<>();
        roles.parallelStream().forEach(role -> role.getPrivileges().parallelStream().forEach(privilege -> privs.add(privilege.getName())));
        return getGrantedAuthorities(privs);
    }

    private final List<GrantedAuthority> getGrantedAuthorities(final Collection<String> privileges) {
        final List<GrantedAuthority> authorities = new ArrayList<>();
        privileges.parallelStream().forEach(privilege -> authorities.add(new SimpleGrantedAuthority(privilege)));
        return authorities;
    }

    public enum FixedUsers {
        Admin,
        Developer,
    }


}
