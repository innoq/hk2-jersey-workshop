package com.innoq.jersey_hk2;

import org.glassfish.jersey.test.JerseyTestNg;
import org.testng.annotations.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.testng.Assert.assertEquals;

public class Uebung3Test extends JerseyTestNg.ContainerPerClassTest {

    @Override
    protected Application configure() {
        return new Uebung3Application();
    }

    @Test
    public void enterLiefertHallo() {
        final Response resp = target("myresource/enter")
                .queryParam("name", "Fred")
                .request().get();
        assertEquals(resp.getStatus(), 200);
        assertEquals(resp.readEntity(String.class),
                "Hallo, Fred");
    }

    @Test
    public void exitLiefertAufWiedersehen() {
        assertEquals(target("myresource/exit").queryParam("name", "Fred").request().get().readEntity(String.class),
                "Auf Wiedersehen, Fred");
    }
}
