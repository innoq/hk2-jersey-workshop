package com.innoq.uebung1;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

import com.innoq.uebung1.beans.DefaultPersonService;
import com.innoq.uebung1.beans.GreetingService;

public class Uebung1 {
    public static void main(String[] args) {
        final ServiceLocator serviceLocator = ServiceLocatorFactory.getInstance().create("uebung1");
        ServiceLocatorUtilities.addClasses(serviceLocator, GreetingService.class, DefaultPersonService.class);
        ServiceLocatorUtilities.bind(serviceLocator, new AbstractBinder() {
            @Override
            public void configure() {
                bind("Horst").named("firstname").to(String.class);
            }
        });

        final GreetingService svc = serviceLocator.getService(GreetingService.class);
        System.out.println(svc.greetPerson());
    }
}
