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

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("null")
    public String nullThrow() {
        throw new NullPointerException("ouch");
    }

    @GET
    @Selected
    @Path("special")
    public String special() {
        return "I'm special";
    }

    @GET
    @Path("dynamic")
    public String dynamic(@QueryParam("name") @DefaultValue("world") String name) {
        return "Hello, " + name;
    }

}
