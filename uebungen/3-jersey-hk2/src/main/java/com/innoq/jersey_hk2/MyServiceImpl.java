package com.innoq.jersey_hk2;

import org.jvnet.hk2.annotations.Service;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Service
public class MyServiceImpl implements MyService {

    @Override
    public String gruesse(String name) {
        // soll "Hallo, {{name}}" bzw. "Auf Wiedersehen, {{name}}" liefern
    }
}
