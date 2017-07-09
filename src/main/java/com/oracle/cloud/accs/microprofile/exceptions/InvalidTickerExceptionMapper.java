package com.oracle.cloud.accs.microprofile.exceptions;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@ApplicationScoped
public class InvalidTickerExceptionMapper implements ExceptionMapper<InvalidTickerException>{

    public InvalidTickerExceptionMapper() {
    }

    @Override
    public Response toResponse(InvalidTickerException e) {
        return Response.status(400).entity(e.getMessage()).build(); //Bad Request
    }
    
}
