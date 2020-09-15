package com.innoq.binder;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Inject;

public class Binder1 extends AbstractBinder {
    @Override
    protected void configure() {
        bind(Dependee.class).to(Dependee.class);
    }

    public static class Dependee {
        @Inject
        private Dependee(Binder2.Dependency dependency) { }
    }
}
