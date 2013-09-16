package org.pentaho.datasource.samples;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.WILDCARD;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

import org.pentaho.platform.web.http.api.resources.JaxbList;

@Path("/echo/api/datasource")
public class EchoDatasourceService {
  List<String> echoDatasourceList = new ArrayList<String>();
  public EchoDatasourceService() {
    echoDatasourceList.add("EchoTestDatasource_1");
    echoDatasourceList.add("EchoTestDatasource_2");
    echoDatasourceList.add("EchoTestDatasource_3");
    echoDatasourceList.add("EchoTestDatasource_4");
  }
  
  @PUT
  @Path("/add")
  @Consumes({ WILDCARD })
  @Produces("text/plain")
  public Response add(String name)  {
      echoDatasourceList.add(name);
      return Response.ok("TRUE").type(MediaType.TEXT_PLAIN).build();
  }
  
  @GET
  @Path("/ids")
  @Produces( { APPLICATION_XML, APPLICATION_JSON })
  public JaxbList<String> getIds() {
    return new JaxbList<String>(echoDatasourceList);
  }
  
  @DELETE
  @Path("/remove")
  @Consumes({ WILDCARD })
  @Produces("text/plain")
  public Response remove(String name)  {
      echoDatasourceList.remove(name);
      return Response.ok("TRUE").type(MediaType.TEXT_PLAIN).build();
  }

}
