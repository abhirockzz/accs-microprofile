package com.oracle.cloud.accs.microprofile.exceptions;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@ApplicationScoped
public class ParsingExceptionMapper implements ExceptionMapper<ParsingException>{

    public ParsingExceptionMapper() {
    }

    @Override
    public Response toResponse(ParsingException e) {
        return Response.status(500).build();
    }
    
}
