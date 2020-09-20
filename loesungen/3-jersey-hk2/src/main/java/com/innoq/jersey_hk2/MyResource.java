package com.innoq.jersey_hk2;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("myresource")
public class MyResource {
    private final MyService svc;

    @Inject
    public MyResource(MyService svc) {
        this.svc = svc;
    }

    @GET
    @Path("enter")
    public String enter(@QueryParam("name") String name) {
        return svc.gruesse(name);
    }

    @GET
    @Path("exit")
    public String exit(@QueryParam("name") String name) {
        return svc.gruesse(name);
    }
}
