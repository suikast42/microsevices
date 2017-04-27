package eu.amova.cloud.platform.service.security.dao;

import eu.amova.cloud.platform.service.security.persistence.Privilege;

import java.util.Collection;

/**
 * @author: vuru
 * Date: 27.04.2017
 * Time: 10:09
 */
public interface PrivilegeRepositoryExtended {

    void registerAppPrivileges(String appId, Collection<Privilege> privileges);
}
