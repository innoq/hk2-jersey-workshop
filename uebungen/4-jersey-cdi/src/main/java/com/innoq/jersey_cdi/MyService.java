package com.innoq.jersey_cdi;

public interface MyService {
    // soll "Hallo, {{name}}" bzw. "Auf Wiedersehen, {{name}}" liefern
    String gruesse(String name);
}
