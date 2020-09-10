package com.innoq.uebung1;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

import com.innoq.uebung1.beans.PersonService;
import com.innoq.uebung1.beans.GreetingService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class Uebung1Test {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Mock
    private PersonService mockPersonService;

    GreetingService greetingService;

    @Before
    public void wire() {
        final ServiceLocator serviceLocator = ServiceLocatorFactory.getInstance().create("uebung1");
        ServiceLocatorUtilities.addClasses(serviceLocator, GreetingService.class);
        ServiceLocatorUtilities.bind(serviceLocator, new AbstractBinder() {
            @Override
            public void configure() {
                bind(mockPersonService).to(PersonService.class);
            }
        });
        when(mockPersonService.getFirstName()).thenReturn("Hildegard");

        greetingService = serviceLocator.getService(GreetingService.class);
    }

    @Test
    public void testGreet() {
        assertEquals("Hallo, Hildegard", greetingService.greetPerson());
    }
}
