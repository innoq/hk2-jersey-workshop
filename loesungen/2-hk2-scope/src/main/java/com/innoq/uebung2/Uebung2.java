package com.innoq.uebung2;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

public class Uebung2 {
    public static void main(String[] args) throws InterruptedException {
        final ServiceLocator locator = ServiceLocatorFactory.getInstance().create("uebung2");
        ServiceLocatorUtilities.addClasses(locator, ThreadLocalScopedContext.class, RandomNameBean.class, Entenhausen.class);

        final Entenhausen svc = locator.getService(Entenhausen.class);
        svc.werWohntWo();
    }
}
