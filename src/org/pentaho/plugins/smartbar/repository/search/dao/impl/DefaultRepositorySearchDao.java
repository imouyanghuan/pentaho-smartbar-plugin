package org.pentaho.plugins.smartbar.repository.search.dao.impl;

import org.pentaho.plugins.smartbar.repository.search.RepositorySearchResult;
import org.pentaho.plugins.smartbar.repository.search.dao.IRepositorySearchDao;
import org.springframework.extensions.jcr.JcrCallback;
import org.springframework.extensions.jcr.JcrTemplate;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import javax.jcr.query.Row;
import java.io.IOException;
import java.util.List;

/**
 * Created by PeterF on 4/26/2014.
 */
public class DefaultRepositorySearchDao implements IRepositorySearchDao {
    JcrTemplate jcrTemplate;

    @Override
    public List<RepositorySearchResult> search(final String query) {
        jcrTemplate.execute( new JcrCallback() {
            @Override
            public Object doInJcr(final Session session) throws RepositoryException, IOException {
                QueryManager queryManager = session.getWorkspace().getQueryManager();
                String expression = "SELECT * FROM pho:File where name like '" + query + "'";
                String language = Query.JCR_SQL2;
                Query query = queryManager.createQuery(expression,language);

                QueryResult result = query.execute();

                javax.jcr.NodeIterator nodeIterator = result.getNodes();

                while(nodeIterator.hasNext()){
                    Node node = nodeIterator.nextNode();
                }

                return null;
            }
        });

        return null;
    }

    public void setJcrTemplate(JcrTemplate jcrTemplate) {
        this.jcrTemplate = jcrTemplate;
    }
}
