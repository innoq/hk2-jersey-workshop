package com.innoq.hk2_extras.aop;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;
import org.glassfish.hk2.extras.interception.internal.DefaultInterceptionService;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

public class AOPMain {
    public static void main(String[] args) {
        ServiceLocator locator = ServiceLocatorFactory.getInstance().create("operation");
        ServiceLocatorUtilities.addClasses(locator, DefaultInterceptionService.class);
        ServiceLocatorUtilities.addClasses(locator, LoggingInterceptor.class, MyService.class);

        MyService s = locator.getService(MyService.class);
        s.foo();
        s.bar();
    }
}
