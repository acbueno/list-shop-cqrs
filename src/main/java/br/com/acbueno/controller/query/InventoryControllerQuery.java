package br.com.acbueno.controller.query;

import br.com.acbueno.service.InvetoryOrderQueryService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/invetory")
public class InventoryControllerQuery {

    @Inject
    private InvetoryOrderQueryService invetoryOrderQueryService;

    @GET
    @Path("/invetory/{id_purchase}")
    public Response getInvetoryByIdPurchase(@PathParam("id_purchase") Long idPurchase) {
        try {
            return Response.ok().entity(invetoryOrderQueryService.getInventoryOrderByPurchase(idPurchase)).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/invetory")
    public Response getInvetoryByAllPurchase() {
        try {
            return Response.ok().entity(invetoryOrderQueryService.getAllInvetoryOrderByPurchase()).build();
        } catch (Exception e) {
           return Response.serverError().build();
        }
    }

}
