package org.pentaho.samples;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.pentaho.platform.util.beans.ActionHarness;

@SuppressWarnings("serial")
public class EchoTestServlet extends HttpServlet {
  
  private static final Log log = LogFactory.getLog(EchoTestServlet.class);

  @SuppressWarnings({ "nls", "unchecked" })
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    /*
     * Best practice is to not doing anything special in your servlet, just wire up the appropriate
     * parameters to an IAction and execute it.  Keeping your important business logic inside your IAction
     * is good because it allows scheduling and inclusion in an Action Sequence.
     * 
     * A situation in which you might chose to put the business logic directly into a servlet is you are 
     * creating a true visualization, in which case there may be no relevant IAction for you to call
     * since you would just be serving JavaScript code or the like.
     */
    try {
      
    EchoAction action = new EchoAction();
    
    /* Use the ActionHarness, a bean utility, to set properties */
    ActionHarness actionBean = new ActionHarness(action);
    actionBean.setValues(req.getParameterMap());
    actionBean.setValue("message", "A Message from the EchoTestServlet");
    actionBean.setValue("echoResponseStream", resp.getOutputStream());
    
    /* now execute the action, which will cause a write to the output stream */
    action.execute();
    
    } catch (Throwable t) {
      log.error("Something broke captain", t);
      throw new RuntimeException("Something broke in EchoTestServlet", t);
    }
  }
}