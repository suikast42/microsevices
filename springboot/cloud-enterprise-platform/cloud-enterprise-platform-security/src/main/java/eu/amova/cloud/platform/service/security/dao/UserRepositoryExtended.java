package eu.amova.cloud.platform.service.security.dao;

import eu.amova.cloud.platform.service.security.persistence.User;

/**
 * @author: vuru
 * Date: 27.04.2017
 * Time: 19:27
 */
public interface UserRepositoryExtended  {

    /**
     *
     * @param login the login name of the user
     * @return  the full tree, user -> roles -> privileges
     */
    User findByLogin(String login);
}
