package eu.amova.cloud.platform.service.security.dao;

import eu.amova.cloud.platform.service.security.persistence.Privilege;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import javax.transaction.TransactionSynchronizationRegistry;
import javax.transaction.UserTransaction;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: vuru
 * Date: 27.04.2017
 * Time: 10:10
 */
// This class must follow the naming convention of spring <JpaRepoName>+Impl
@Transactional
class PrivilegeRepositoryImpl implements PrivilegeRepositoryExtended {

    @Autowired
    private Log logger;


    @Autowired
    private PrivilegeRepository baseRepo;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void registerAppPrivileges(String appId, Collection<Privilege> privileges) {

        Set<Privilege> invalidPrivileges = privileges.stream().filter(priv -> !priv.getAppId().equals(appId)).collect(Collectors.toSet());
        if (!invalidPrivileges.isEmpty()) {
            throw new RuntimeException(MessageFormat.format("Some privileges contains invalid appIds for appId {0}. Count of invalid privileges {1}", appId, invalidPrivileges.size()));
        }
        TypedQuery<Privilege> query = em.createNamedQuery(Privilege.NQ_ALL_BY_APPID, Privilege.class);
        query.setParameter("appId", appId);
        List<Privilege> actualPrivileges = query.getResultList();

        Set<Privilege> newPrivileges = privileges.parallelStream().filter(priv -> !actualPrivileges.contains(priv)).collect(Collectors.toSet());
        Set<Privilege> toDeletePrivileges = actualPrivileges.parallelStream().filter(priv -> !privileges.contains(priv)).collect(Collectors.toSet());

        Privilege[] tmp = privileges.toArray(new Privilege[]{});

        if(!toDeletePrivileges.isEmpty()) {
            baseRepo.deleteInBatch(toDeletePrivileges);
        }

        if(!newPrivileges.isEmpty()) {
            baseRepo.save(newPrivileges);
        } 
    }
}
