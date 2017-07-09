package com.oracle.cloud.accs.microprofile.exceptions;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@ApplicationScoped
public class PriceFetchExceptionMapper implements ExceptionMapper<PriceFetchException>{

    public PriceFetchExceptionMapper() {
    }

    @Override
    public Response toResponse(PriceFetchException e) {
        return Response.status(500).entity(e.getMessage()).build();
    }
    
}
