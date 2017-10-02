package no.ntnu.monitoring;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/systemStatus")
public class SystemStatusResource {

    @GET
    public Response getSystemStatus() {
        return Response.ok("Hello world").build();
    }
}
