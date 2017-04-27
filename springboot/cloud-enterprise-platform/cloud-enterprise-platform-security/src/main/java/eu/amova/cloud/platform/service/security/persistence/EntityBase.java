package eu.amova.cloud.platform.service.security.persistence;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

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

    @Column(name = "UUID",length = 42)
    private String uuid;

    @Column(name = "LASTCHANGETIME", nullable = false, length = 11)
    @NotNull
    private LocalDateTime lastChangeTime;
    @Column(name = "CREATIONTIME", nullable = false, length = 11)
    @NotNull
    private LocalDateTime creationTime;

    public EntityBase() {
        creationTime = LocalDateTime.now();
        uuid = UUID.randomUUID().toString();
    }

    @PrePersist
    private void prePersist() {
        preUpdate();
    }

    @PreUpdate
    private void preUpdate() {
        lastChangeTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getLastChangeTime() {
        return lastChangeTime;
    }

    public void setLastChangeTime(LocalDateTime lastChangeTime) {
        this.lastChangeTime = lastChangeTime;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public String getUuid() {
        return uuid;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        //    if (!super.equals(obj))
        //      return false;
        //    if (getClass() != obj.getClass()) {
        if (Hibernate.getClass(this) != Hibernate.getClass(obj)) {
            return false;
        }
        if (!(obj instanceof EntityBase)) {
            return false;
        }
        EntityBase other = (EntityBase) obj;

        if (getId() != null && getId().equals(other.getId())) {
            return true;
        }
        if (!getCreationTime().equals(other.getCreationTime())) {
            return false;
        }
        if (!getUuid().equals(other.getUuid())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", lastChangeTime=" + lastChangeTime +
                ", creationTime=" + creationTime;
    }

//    private static class AtomicIntegerWarpper {
//        private static final AtomicInteger atomicInteger = new AtomicInteger(0);
//
//        public static final int incrementAndGet() {
//            int returnvalue = atomicInteger.incrementAndGet();
//            if (returnvalue >= 1000) {
//                atomicInteger.set(0);
//                returnvalue = atomicInteger.incrementAndGet();
//                System.err.println("RESETT");
//            }
//            return returnvalue;
//        }
//    }
}
