package com.nokla.demojsf;

import com.nokla.demojsf.dto.OfficerDTO;
import com.nokla.demojsf.entity.user.Office;
import com.nokla.demojsf.entity.user.OfficeRole;
import com.nokla.demojsf.entity.user.Officer;
import com.nokla.demojsf.service.OfficeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/office")
public class OfficeResources {

    @Inject
    OfficeService officeService;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOffices(){
        List<Office> offices = officeService.getAllOffices();
        offices.forEach(System.out::println);
        return Response.ok(offices).build();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOffice(@PathParam("id") Long id){
        Office office = officeService.getOfficeById(id);
        System.out.println(office);
        return Response.ok(office).build();
    }

    @GET
    @Path("/officer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOfficerRoles(){
        List<Officer> officers = officeService.getAllOfficers();
        officers.forEach(System.out::println);
        return Response.ok(officers).build();
    }

    @GET
    @Path("/officer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOfficerRoles(@PathParam("id") Long id){
        Officer officer = officeService.getOfficerById(id);
        System.out.println(officer);
        return Response.ok(officer).build();
    }

    @GET
    @Path("/dto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOfficerDTOS(){
        List<OfficerDTO> officerDTOS = officeService.getOfficerDTOS();
        officerDTOS.forEach(System.out::println);
        return Response.ok(officerDTOS).build();
    }
}
