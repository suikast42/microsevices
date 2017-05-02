package eu.amova.cloud.platform.service.security.dao;

import eu.amova.cloud.platform.service.security.persistence.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * @author: vuru
 * Date: 27.04.2017
 * Time: 19:27
 */
public class UserRepositoryImpl implements UserRepositoryExtended {


    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public User findByLogin(String login) {
        try {
          return
                  em.createQuery("select u from User u left join u.roles where u.login=:login ", User.class)
//                  em.createQuery("select u from User u left join  u.roles rls where u.login=:login ", User.class)
                    .setParameter("login",login)
                    .getSingleResult();

        } catch (EntityNotFoundException | NoResultException e) {
            return null;
        }
        //        EntityGraph<User> entityGraph = em.createEntityGraph(User.class);
//        entityGraph.addAttributeNodes("roles");
//        entityGraph.addSubgraph("privileges",Privilege.class);
//        try {
//            return em.createQuery("select o from User o where o.login=:login", User.class)
//                    .setParameter("login", login).setHint("javax.persistence.loadgraph", entityGraph).getSingleResult();
//        } catch (EntityNotFoundException e) {
//            return null;
//        }

    }
}
