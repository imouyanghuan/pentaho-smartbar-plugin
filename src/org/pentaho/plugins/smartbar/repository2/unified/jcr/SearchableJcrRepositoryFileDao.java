package org.pentaho.plugins.smartbar.repository2.unified.jcr;

import org.pentaho.platform.api.repository2.unified.IRepositoryDefaultAclHandler;
import org.pentaho.platform.api.repository2.unified.IRepositoryFileData;
import org.pentaho.platform.api.repository2.unified.RepositoryFile;
import org.pentaho.platform.repository2.messages.Messages;
import org.pentaho.platform.repository2.unified.IRepositoryFileAclDao;
import org.pentaho.platform.repository2.unified.RepositoryAccessVoterManager;
import org.pentaho.platform.repository2.unified.jcr.IDeleteHelper;
import org.pentaho.platform.repository2.unified.jcr.ILockHelper;
import org.pentaho.platform.repository2.unified.jcr.IPathConversionHelper;
import org.pentaho.platform.repository2.unified.jcr.ITransformer;
import org.springframework.extensions.jcr.JcrCallback;
import org.springframework.extensions.jcr.JcrTemplate;
import org.springframework.util.StringUtils;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryResult;
import javax.jcr.query.qom.Constraint;
import javax.jcr.query.qom.QueryObjectModelConstants;
import javax.jcr.query.qom.Selector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pminutillo on 12/31/13.
 */
public class SearchableJcrRepositoryFileDao {
    private JcrTemplate jcrTemplate;

    private List<ITransformer<IRepositoryFileData>> transformers;

    private ILockHelper lockHelper;

    private IDeleteHelper deleteHelper;

    private IPathConversionHelper pathConversionHelper;

    private IRepositoryFileAclDao aclDao;

    private IRepositoryDefaultAclHandler defaultAclHandler;

    private RepositoryAccessVoterManager accessVoterManager;

    public SearchableJcrRepositoryFileDao() {
    }

    public SearchableJcrRepositoryFileDao(JcrTemplate jcrTemplate, List<ITransformer<IRepositoryFileData>> transformers, ILockHelper lockHelper, IDeleteHelper deleteHelper, IPathConversionHelper pathConversionHelper, IRepositoryFileAclDao aclDao, IRepositoryDefaultAclHandler defaultAclHandler, RepositoryAccessVoterManager accessVoterManager) {
        this.jcrTemplate = jcrTemplate;
        this.transformers = transformers;
        this.lockHelper = lockHelper;
        this.deleteHelper = deleteHelper;
        this.pathConversionHelper = pathConversionHelper;
        this.aclDao = aclDao;
        this.defaultAclHandler = defaultAclHandler;
        this.accessVoterManager = accessVoterManager;
    }

    public void executeXpathQuery( String query ){
        jcrTemplate.execute( new JcrCallback() {
            @Override
            public Object doInJcr( final Session session ) throws RepositoryException, IOException {
                return null;
            }
        });
    }

    public void executeJcrSql2Query( String query ){
        jcrTemplate.execute( new JcrCallback() {
            @Override
            public Object doInJcr( final Session session ) throws RepositoryException, IOException {

/*                // selector
                final Selector selector = fac.selector( "nt:base", selectorName ); //$NON-NLS-1$
                // constraint1
                Constraint origParentFolderPathConstraint =
                        fac.comparison( fac.propertyValue( selectorName, pentahoJcrConstants.getPHO_ORIGPARENTFOLDERPATH() ),
                                QueryObjectModelConstants.JCR_OPERATOR_EQUAL_TO, fac.literal( session.getValueFactory().createValue(
                                origParentFolderPath ) ) );
                // constraint2
                Constraint origNameConstraint = null;
                if ( StringUtils.hasLength(filter) ) {
                    String convertedFilter = filter.replace( '*', '%' );
                    origNameConstraint =
                            fac.comparison( fac.propertyValue( selectorName, pentahoJcrConstants.getPHO_ORIGNAME() ),
                                    QueryObjectModelConstants.JCR_OPERATOR_LIKE, fac.literal( session.getValueFactory().createValue(
                                    convertedFilter ) ) );
                }
                // constraint3
                Constraint descendantNodeConstraint = fac.descendantNode( selectorName, trashNode.getPath() );
                // AND together constraints
                Constraint allConstraints = fac.and( descendantNodeConstraint, origParentFolderPathConstraint );
                if ( StringUtils.hasLength( filter ) ) {
                    allConstraints = fac.and( allConstraints, origNameConstraint );
                }
                Query query = fac.createQuery( selector, allConstraints, null, null );
                QueryResult result =
                        session.getWorkspace().getQueryManager().createQuery( query.getStatement(), Query.JCR_JQOM ).execute();

                NodeIterator nodeIter = result.getNodes();
                List<RepositoryFile> deletedFiles = new ArrayList<RepositoryFile>();

                while ( nodeIter.hasNext() ) {
                    Node trashFileIdNode = nodeIter.nextNode();
                    if ( trashFileIdNode.hasNodes() ) {
                        // since the nodes returned by the query are the trash file ID nodes, need to getNodes().nextNode() to get
                        // first
                        // (and only) child
                        deletedFiles.add( nodeToDeletedFile( session, pentahoJcrConstants, trashFileIdNode.getNodes().nextNode() ) );
                    } else {
                        throw new RuntimeException( Messages.getInstance().getString( "DefaultDeleteHelper.ERROR_0002_NOT_CLEAN" ) ); //$NON-NLS-1$
                    }
                }*/


                return null;
            }
        });
    }
}

