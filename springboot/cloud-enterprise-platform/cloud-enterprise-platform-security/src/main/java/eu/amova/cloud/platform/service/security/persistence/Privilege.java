package eu.amova.cloud.platform.service.security.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * @author: vuru
 * Date: 26.04.2017
 * Time: 15:46
 */
@Entity
@Table(name = "role_privilege")
public class Privilege extends  EntityBase{

    @Column(length = 4096)
    @NotNull
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

    public Privilege() {
       this(null);
    }

    public Privilege(final String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(final Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Privilege{ " +super.toString()+
                " name='" + name + '\'' +
                '}';
    }
}
