package com.innoq.jersey_extras;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.testng.annotations.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.testng.Assert.assertEquals;

public class TestResourceTest extends JerseyTestNg.ContainerPerClassTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(TestResource.class);
    }

    @Test
    public void testReturnsOk() {
        final Response resp = target("test").request().get();

        assertEquals(resp.getStatus(), 200);
        assertEquals(resp.readEntity(String.class), "ok");
    }
}