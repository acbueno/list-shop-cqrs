package br.com.acbueno.controller.command;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import br.com.acbueno.dto.PurchaseRequestDTO;
import br.com.acbueno.service.PurchaseCommandService;
import br.com.acbueno.service.impl.PurchaseCommandServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/pusrchase")
public class PurchaseCommandController {

    @Inject
    private PurchaseCommandService purchaseCommandService;

    @POST
    @Path("/create")
    public Response createPurchase(@RequestBody PurchaseRequestDTO purchaseDTO) {
        try {
            return Response.ok().entity(purchaseCommandService.createPurchaseDTO(purchaseDTO)).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/cancel/{idPurchase}")
    public Response cancelPurchase(@PathParam("idPurchase") Long idPurchase) {
        try {
             purchaseCommandService.cancelPurchaseDTO(idPurchase);
             return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

}
