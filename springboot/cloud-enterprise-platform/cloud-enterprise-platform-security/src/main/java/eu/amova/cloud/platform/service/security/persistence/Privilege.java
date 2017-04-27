package eu.amova.cloud.platform.service.security.persistence;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * @author: vuru
 * Date: 26.04.2017
 * Time: 15:46
 */
@Entity
@Table(name = "role_privilege",
        indexes = {
                @Index(name = "IDX_role_privilege_NAME", columnList = "appId"),
                @Index(name = "IDX_role_privilege_APPID", columnList = "name"),
                @Index(name = "IDX_role_privilege_NAME_APPID", unique = true, columnList = "name,appId"),
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "IDX_role_privilege_APP_ID_NAME", columnNames = {"appId", "name"})
        })
@NamedQueries({
        @NamedQuery(name = Privilege.NQ_ALL_BY_APPID, query = "select o from Privilege o where o.appId = :appId")
})
public class Privilege extends EntityBase {

    public static final String NQ_ALL_BY_APPID = "Privilege.by.appId";

    @Column(length = 4096)
    @NotNull
    private String name;

    @Column(length = 256)
    @NotNull
    private String appId;


    @Column(length = 4096)
    @NotNull
    private String description;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

    public Privilege() {
        this(null, null);
    }

    public Privilege(final String appid, final String name) {
        this(appid, name, null);
    }

    public Privilege(final String appid, final String name, String description) {
        super();
        this.name = name;
        this.appId = appid;
        this.description = description;
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

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descrpition) {
        this.description = descrpition;
    }

    @Override
    public String toString() {
        return "Privilege{ " + super.toString() +
                " appId='" + appId + '\'' +
                " name='" + name + '\'' +
                " description='" + description + '\'' +
                '}';
    }

}
