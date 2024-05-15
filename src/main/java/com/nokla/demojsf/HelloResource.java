package com.nokla.demojsf;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

    // get plain text
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return "hello from API!";
    }

    // get a json object
    @GET()
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject hello1(){
        return Json.createObjectBuilder().add("message", "Hello from API!").build();
    }

    // get by a url param
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject hello2(@PathParam("name") String name){
        return Json.createObjectBuilder().add("msg", "Hello who are u?").add("name", name).build();
    }
}
