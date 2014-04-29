package org.pentaho.plugins.smartbar.repository.search.service;

import org.pentaho.plugins.smartbar.repository.search.RepositorySearchResult;
import org.pentaho.plugins.smartbar.repository.search.dao.IRepositorySearchDao;

import java.util.List;

/**
 * Created by PeterF on 4/26/2014.
 */
public interface IRepositorySearchService {
    void setRepositorySearchDao( IRepositorySearchDao searchDao );
    List<RepositorySearchResult> search( String query );
}
