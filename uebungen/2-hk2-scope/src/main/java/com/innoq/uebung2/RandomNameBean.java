package com.innoq.uebung2;

import java.util.Arrays;
import java.util.List;

// sorge dafür, dass diese Bean ThreadLocalScoped wird
public class RandomNameBean {
    private static final List<String> NAMES =
            Arrays.asList("Donald", "Dagobert", "Daisy", "Tick", "Trick", "Track", "Gustav", "Gundel", "Mickey", "Mini",
                    "Goofy", "Pluto");

    public String getName() {
        // TODO sorge dafür, dass jede Instanz der Bean immer den gleichen, zufälligen Namen liefert
    }

}
