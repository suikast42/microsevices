package eu.amova.cloud.platform.service.security.persistence;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author: vuru
 * Date: 26.04.2017
 * Time: 09:38
 */

@MappedSuperclass
public class EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "LASTCHANGETIME", nullable = false, length = 11)
    @NotNull
    private Date lastChangeTime;

    @Column(name = "CREATIONTIME", nullable = false, length = 11)
    @NotNull
    private Date creationTime;

    @PrePersist
    private void prePersist() {
        if (creationTime == null) {
            creationTime = new Date();
        }
        if (lastChangeTime == null) {
            lastChangeTime = new Date();
        }
    }

    @PreUpdate
    private void preUpdate() {
        lastChangeTime = new Date();
    }

    public Long getId() {
        return id;
    }


    public Date getLastChangeTime() {
        return lastChangeTime;
    }

    public void setLastChangeTime(Date lastChangeTime) {
        this.lastChangeTime = lastChangeTime;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntityBase)) return false;

        EntityBase that = (EntityBase) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", lastChangeTime=" + lastChangeTime +
                ", creationTime=" + creationTime;
    }
}
