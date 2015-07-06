package nl.sytac.edu.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Service class for our REST endpoint
 */

@Path("/inventory/status")
public class InventoryResource {

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateStatus(String status) {
        return null;
    }
}
