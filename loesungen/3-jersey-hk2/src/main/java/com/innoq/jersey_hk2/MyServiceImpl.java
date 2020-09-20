package com.innoq.jersey_hk2;

import org.jvnet.hk2.annotations.Service;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Service
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
