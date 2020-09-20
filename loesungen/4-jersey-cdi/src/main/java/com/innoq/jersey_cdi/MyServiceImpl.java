package com.innoq.jersey_cdi;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

public class MyServiceImpl implements MyService {
    @Context
    private UriInfo uriInfo;

    @Override
    public String gruesse(String name) {
        if (uriInfo.getPath().endsWith("enter")) {
            return "Hallo, " + name;
        } else {
            return "Auf Wiedersehen, " + name;
        }
    }
}
