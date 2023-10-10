package br.com.acbueno.controller.command;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import br.com.acbueno.dto.ProductRequestDTO;
import br.com.acbueno.service.ProductCommandService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/product")
public class ProductCommandController {

    @Inject
    ProductCommandService productCommandService;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProductDTO(@RequestBody ProductRequestDTO productDTO, Long id) {
        try {
            return Response.ok().entity(productCommandService.createProduct(productDTO)).build();
        } catch (Exception e) {
           return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/cancel/{nameBrand}")
    public Response cancel(@PathParam("nameBrand") String name) {
        try {
             productCommandService.cancelProductByBrandName(name);
             return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

}
