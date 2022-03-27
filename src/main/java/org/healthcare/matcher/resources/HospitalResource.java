package org.healthcare.matcher.resources;

import org.healthcare.matcher.entities.api.Hospital;
import org.healthcare.matcher.repositories.HospitalRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hospitals/{hospitalId}")
@Produces(MediaType.APPLICATION_JSON)
public class HospitalResource {
    private final HospitalRepository repository;

    public HospitalResource(final HospitalRepository repository) {
        this.repository = repository;
    }

    @GET
    public Hospital getHospital(@PathParam("hospitalId") final int hospitalId) {
        final Hospital result = repository.get(hospitalId);
        if (result == null) {
            throw new WebApplicationException(String.format("hospital id %s not found", hospitalId),
                    Response.Status.NOT_FOUND);
        }
        return result;
    }

}
