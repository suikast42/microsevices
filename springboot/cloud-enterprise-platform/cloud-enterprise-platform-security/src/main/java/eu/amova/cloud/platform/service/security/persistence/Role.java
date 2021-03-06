package eu.amova.cloud.platform.service.security.persistence;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: vuru
 * Date: 26.04.2017
 * Time: 15:43
 */
@Entity
@Table(name = "Roles")
public class Role extends EntityBase {

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    private Set<Privilege> privileges = new HashSet<>();
    @Column(length = 256)
    @NotNull
    private String name;

    public Role() {
        super();
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{ " + super.toString() +
                " name='" + name + '\'' +
                '}';
    }

    public enum FixedRoles {
        Administrator,
        Developer,
        ACTUATOR,
    }
}
