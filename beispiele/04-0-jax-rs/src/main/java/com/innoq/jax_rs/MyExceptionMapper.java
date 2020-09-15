package com.innoq.jax_rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyExceptionMapper implements ExceptionMapper<NullPointerException> {
    @Override
    public Response toResponse(NullPointerException e) {
        return Response.status(400).entity("Das war null").type(MediaType.TEXT_PLAIN_TYPE).build();
    }
}
