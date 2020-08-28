package com.example.model;

import org.glassfish.hk2.api.Descriptor;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;
import org.glassfish.hk2.utilities.BuilderHelper;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

public class MovieListerViaExplicitHK2BindingTest extends AbstractMovieListerTest {

    @Override
    protected MovieLister lister() {
        final ServiceLocator serviceLocator = ServiceLocatorFactory.getInstance().create("mein locator");
        final Descriptor finder = BuilderHelper.link(MovieFinderImpl.class).to(MovieFinder.class).build();
        ServiceLocatorUtilities.addOneDescriptor(serviceLocator, finder);
        final Descriptor lister = BuilderHelper.link(MovieLister.class).build();
        ServiceLocatorUtilities.addOneDescriptor(serviceLocator, lister);
        return serviceLocator.getService(MovieLister.class);
    }

}
