package no.ntnu.monitoring;

import no.ntnu.monitoring.networking.NetworkStatisticsFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.logging.Level;
import java.util.logging.Logger;


@Path("/systemStatus")
public class SystemStatusResource {

    private static final Logger LOGGER = Logger.getLogger(SystemStatusResource.class.getName());

    @GET
    public Response getSystemStatus() {
        return Response.ok("Hello world").build();



        /*
        • Bytes sent/received
        • Packets sent/received
        • Power usage (watt)
        • Requests sent
        • Requests received
         */
    }

    /**
     *
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCPUUsage() {
        return Response.ok(ManagementFactory.getOperatingSystemMXBean()).build();
    }

    @GET
    @Path("/network")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSomethingElse() {
        try {
            return Response.ok(NetworkStatisticsFactory.getNetworkInterfaces()).build();
        } catch (Exception   e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return Response.serverError().build();
        }
    }
}
