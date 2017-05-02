package eu.amova.cloud.platform.service.security.dao;

import eu.amova.cloud.platform.service.security.persistence.User;

/**
 * @author: vuru
 * Date: 27.04.2017
 * Time: 19:27
 */
public interface UserRepositoryExtended  {
    User findByLogin(String login);
}
