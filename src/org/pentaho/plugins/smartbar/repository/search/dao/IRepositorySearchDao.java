package org.pentaho.plugins.smartbar.repository.search.dao;

import org.pentaho.plugins.smartbar.repository.search.RepositorySearchResult;

import java.util.List;

/**
 * Created by PeterF on 4/26/2014.
 */
public interface IRepositorySearchDao {
    List<RepositorySearchResult> search( String query );
}
