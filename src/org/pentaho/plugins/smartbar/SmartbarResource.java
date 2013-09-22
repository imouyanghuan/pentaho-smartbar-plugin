package org.pentaho.plugins.smartbar;

import javax.ws.rs.*;

/**
 *
 */
@Path("/smartbar/api")
public class SmartbarResource {
    @GET
    @Path("search")
    @Consumes("text/plain")
    public String search(@QueryParam("query") String query) throws Exception {
        System.out.println("Here is a query: " + query);
        return("Here is a query: " + query);
    }
}
