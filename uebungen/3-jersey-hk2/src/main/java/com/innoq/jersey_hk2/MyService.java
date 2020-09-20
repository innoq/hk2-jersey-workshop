package com.innoq.jersey_hk2;

import org.jvnet.hk2.annotations.Contract;

@Contract
public interface MyService {
    // soll "Hallo, {{name}}" bzw. "Auf Wiedersehen, {{name}}" liefern
    String gruesse(String name);
}
