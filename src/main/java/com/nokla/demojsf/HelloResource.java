package com.nokla.demojsf;

import com.nokla.demojsf.entity.Message;
import com.nokla.demojsf.service.MessageService;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/messages")
public class HelloResource {

    @Inject
    private MessageService messageService;

    // get plain text
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> findAll() {
        return messageService.getMessages();
    }

    // get a by id
    @GET()
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id){
        Optional<Message> message = messageService.getMessage(id);
        if(message.isPresent()){
            return Response.ok(message.get()).build();
        } else {
            return Response.status(404, "message not found").build();
//            return Response.noContent().build();

        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMessage(Message message){
        try{
            messageService.create(message);
            return Response.accepted(message).build();
        } catch (Exception e){
            return Response.status(400, e.getMessage()).build();
//            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateMessage(@PathParam("id") Long id, Message message ){
        try {
            Optional<Message> existingMessage = messageService.getMessage(id);
            if(existingMessage.isEmpty()){
                return Response.status(404, "message not found").build();
            }
            message.setId(existingMessage.get().getId());
            messageService.updateMessage(message);
            return Response.accepted(message).build();
        } catch (Exception e){
            return Response.notModified(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMessage(@PathParam("id") Long id){
        try{
            messageService.delete(id);
            return Response.ok().build();
        } catch (Exception e){
            return Response.notModified(e.getMessage()).build();
        }
    }


    // get by a url param
//    @GET
//    @Path("/name/{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public JsonObject hello2(@PathParam("name") String name){
//        return Json.createObjectBuilder().add("msg", "Hello who are u?").add("name", name).build();
//    }


}
