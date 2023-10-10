package br.com.acbueno.controller.query;

import br.com.acbueno.service.ProductQueryService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/product/query")
public class ProductControllerQuery {

    @Inject
    ProductQueryService productQueryService;

    @GET
    @Path("/find/id/{idProduct}")
    public Response getProductById(@PathParam("idProduct") Long id) {
        try {
            return Response.ok().entity(productQueryService.getProductById(id)).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/find/all")
    public Response getAllProduct() {
        try {
            return Response.ok().entity(productQueryService.getAllProduct()).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/find/brand/{brandName}")
    public Response getProductByBrandName(@PathParam("brandName") String brandName) {
        try {
            return Response.ok().entity(productQueryService.getProductsByBrandName(brandName)).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

}
