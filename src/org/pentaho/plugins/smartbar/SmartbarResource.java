package org.pentaho.plugins.smartbar;

import org.pentaho.plugins.smartbar.repository.search.service.IRepositorySearchService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 */
@Path("/smartbar/api")
public class SmartbarResource {
    IRepositorySearchService searchService;

    @GET
    @Path("search")
    @Consumes("text/plain")
    public Response search(@QueryParam("query") String query) {
        System.out.println("Here is a query: " + query);

        return Response.ok(searchService.search(query)).build();
    }

    public void setSearchService(IRepositorySearchService searchService) {
        this.searchService = searchService;
    }
}
