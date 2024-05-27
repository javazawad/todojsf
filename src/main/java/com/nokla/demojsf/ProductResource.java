package com.nokla.demojsf;

import com.nokla.demojsf.dto.ProductDTO;
import com.nokla.demojsf.entity.Product;
import com.nokla.demojsf.service.ProductService;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/products")
public class ProductResource {
    @Inject
    ProductService productService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {
        List<Product> products = productService.getAllProducts();
        products.forEach(System.out::println);
        List<ProductDTO> productDTOS = productService.getAllProductsDTO();
        productDTOS.forEach(System.out::println);
        return Response.ok(productDTOS).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") Long id) {
        Product product = productService.getProductById(id);
        System.out.println(product);
        ProductDTO productDTO = productService.getProductsDTO(id).orElse(null);
        System.out.println(productDTO);
        return Response.ok(productDTO).build();
    }



    @GET()
    @Path("/msg")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject hello1(){
        return Json.createObjectBuilder().add("message", "Hello from API!").build();
    }



}
