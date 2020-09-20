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
    // soll "Hallo, {{name}}" liefern
    public String enter(@QueryParam("name") String name) {
        return svc.gruesse(name);
    }

    @GET
    @Path("exit")
    // soll "Auf Wiedersehen, {{name}}" liefern
    public String exit(@QueryParam("name") String name) {
        return svc.gruesse(name);
    }
}
