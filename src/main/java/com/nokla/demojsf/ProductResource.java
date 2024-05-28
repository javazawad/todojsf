package com.nokla.demojsf;

import com.nokla.demojsf.entity.Product;
import com.nokla.demojsf.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/products")
public class ProductResource {
    @Inject
    ProductService productService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> findAll() {
        return productService.getProducts();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") Long id){
        try {
            Optional<Product> optionalProduct = productService.getById(id);
            if(optionalProduct.isPresent()){
                return Response.ok(optionalProduct.get()).build();
            } else {
                return Response.status(404,"Product not found").build();
            }
        } catch (Exception e){
            return Response.status(404,e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(Product product){
        try{
            productService.create(product);
            return Response.accepted(product).build();
        } catch (Exception e){
            return Response.status(400, e.getMessage()).build();
//            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }
}
