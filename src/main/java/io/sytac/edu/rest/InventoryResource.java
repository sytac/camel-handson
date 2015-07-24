package io.sytac.edu.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Service class for our REST endpoint
 */

@Path("/inventory/status")
public interface InventoryResource {

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    Response updateStatus(String status);
}
