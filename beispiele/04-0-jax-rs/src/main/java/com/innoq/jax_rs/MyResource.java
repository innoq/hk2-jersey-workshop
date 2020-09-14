package com.innoq.jax_rs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("myresource")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam("name") @DefaultValue("world") String name) {
        return "Hello, " + name;
    }

}
