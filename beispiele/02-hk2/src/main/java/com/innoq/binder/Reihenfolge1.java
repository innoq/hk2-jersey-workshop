package com.innoq.binder;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

public class Reihenfolge1 {
    public static void main(String[] args) {
        ServiceLocator locator = ServiceLocatorFactory.getInstance().create("binder");
        ServiceLocatorUtilities.bind(locator, new Binder1());
        ServiceLocatorUtilities.bind(locator, new Binder2());

        System.err.println(locator.getService(Binder1.Dependee.class));
    }
}
