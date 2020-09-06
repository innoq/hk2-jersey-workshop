package com.innoq.model;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

public class MovieListerViaHK2Test extends AbstractMovieListerTest {

    @Override
    protected MovieLister lister() {
        final ServiceLocator serviceLocator = ServiceLocatorFactory.getInstance().create("mein locator");
        ServiceLocatorUtilities.addClasses(serviceLocator, MovieFinderImpl.class, MovieLister.class);
        return serviceLocator.getService(MovieLister.class);
    }

}
