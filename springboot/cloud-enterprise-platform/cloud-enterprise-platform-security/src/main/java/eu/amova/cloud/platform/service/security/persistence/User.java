package eu.amova.cloud.platform.service.security.persistence;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

/**
 * @author: vuru
 * Date: 26.04.2017
 * Time: 15:26
 */
@Entity
@Table(name = "user_account")
public class User extends EntityBase {

    @Column (length = 255)
    @NotNull
    private String login;

    @Column
    @NotNull
    private Locale locale;
    
    @Column (length = 255)
    @NotNull
    private String firstName;

    @Column (length = 255)
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles = new HashSet<>();

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

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
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
}
