package org.pentaho.samples;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.pentaho.platform.util.beans.ActionHarness;

@Path("/echo/api/echo")
public class EchoResource {
  
  @GET
  @Path("{message}")
  @Consumes("text/plain")
  public String say(@PathParam("message") String message) throws Exception {
    EchoAction action = new EchoAction();
    
    /* Use the ActionHarness, a bean utility, to set properties.
     * You could of course call the setters directly, just doing this out of convention
     * and because the ActionHarness will allow me to set maps of params should I want to do that
     * later. */
    ActionHarness actionBean = new ActionHarness(action);
    actionBean.setValue("message", message);
    
    /* now execute the action, which will cause a value to be written to the echoMessage property */
    action.execute();
    
    return "This is the EchoResource. Your message is enclosed ["+action.getEchoMessage()+"]";
  }

}
