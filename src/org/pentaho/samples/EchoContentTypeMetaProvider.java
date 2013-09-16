package org.pentaho.samples;

import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.pentaho.platform.api.engine.IFileInfo;
import org.pentaho.platform.api.engine.ISolutionFile;
import org.pentaho.platform.api.engine.SolutionFileMetaAdapter;
import org.pentaho.platform.engine.core.solution.FileInfo;

public class EchoContentTypeMetaProvider extends SolutionFileMetaAdapter {

  Log logger = LogFactory.getLog(EchoContentTypeMetaProvider.class);

  @Override
  public IFileInfo getFileInfo(ISolutionFile solutionFile, InputStream in) {

    /**
     * You can mine this info out of your file if you have it
     */
    try {
      IFileInfo info = new FileInfo();
      info.setAuthor("Dr Suess");
      info.setDescription("Some Description");
      info.setDisplayType("Some DisplayType");
      info.setTitle(solutionFile.getFileName());
      return info;
    } catch (Exception e) {
      logger.error("Error creating meta information for file type " + solutionFile.getExtension(), e); //$NON-NLS-1$
      return null;
    }
  }

}
