package com.innoq.uebung2;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

@ThreadLocalScoped
public class RandomNameBean {
    private static final List<String> NAMES =
            Arrays.asList("Donald", "Dagobert", "Daisy", "Tick", "Trick", "Track", "Gustav", "Gundel", "Mickey", "Mini",
                    "Goofy", "Pluto");

    private final String name;

    public RandomNameBean() {
        name = NAMES.get(new SecureRandom().nextInt(NAMES.size()));
    }

    public String getName() {
        return name;
    }

}
