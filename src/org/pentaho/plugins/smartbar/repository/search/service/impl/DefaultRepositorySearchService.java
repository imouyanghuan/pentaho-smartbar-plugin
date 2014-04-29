package org.pentaho.plugins.smartbar.repository.search.service.impl;

import org.pentaho.plugins.smartbar.repository.search.RepositorySearchResult;
import org.pentaho.plugins.smartbar.repository.search.dao.IRepositorySearchDao;
import org.pentaho.plugins.smartbar.repository.search.service.IRepositorySearchService;

import java.util.List;

/**
 * Created by PeterF on 4/26/2014.
 */
public class DefaultRepositorySearchService implements IRepositorySearchService {
    IRepositorySearchDao searchDao;

    @Override
    public List<RepositorySearchResult> search(String query) {
        return searchDao.search( query );
    }

    @Override
    public void setRepositorySearchDao(IRepositorySearchDao searchDao) {
        this.searchDao = searchDao;
    }
}
