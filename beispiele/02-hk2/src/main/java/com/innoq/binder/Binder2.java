package com.innoq.binder;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class Binder2 extends AbstractBinder {
    @Override
    protected void configure() {
        bind(Dependency.class).to(Dependency.class);
    }

    public static class Dependency { }
}
