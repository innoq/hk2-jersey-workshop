package com.innoq.jersey_cdi;

public class MyServiceImpl implements MyService {

    @Override
    public String gruesse(String name) {
        // soll "Hallo, {{name}}" bzw. "Auf Wiedersehen, {{name}}" liefern
    }
}
