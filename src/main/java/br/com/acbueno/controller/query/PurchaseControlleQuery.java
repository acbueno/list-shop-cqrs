package br.com.acbueno.controller.query;

import br.com.acbueno.service.PurchaseQueryService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/purchase/query")
public class PurchaseControlleQuery {


    @Inject
    private PurchaseQueryService purchaseQueryService;

    @GET
    @Path("/all")
    public Response getAllPurchase() {
        try {
            return Response.ok().entity(purchaseQueryService.getAllPurchase()).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/date/{date}")
    public Response getAllPurchaseByDate(@PathParam("date") String date) {
        try {

            return Response.ok().entity(purchaseQueryService.getPurchaseByDate(date)).build();
        } catch (Exception e) {
           return Response.serverError().build();
        }
    }

    @GET
    @Path("/id/{idPurchase}")
    public Response getPurchaseById(@PathParam("idPurchase") Long id) {
        try {
            return Response.ok().entity(purchaseQueryService.getPurchaseById(id)).build();
        } catch (Exception e) {
           return Response.serverError().build();
        }
    }

}
