package com.innoq.jersey_hk2;

import org.testng.annotations.Test;

import javax.ws.rs.core.Response;

import static org.testng.Assert.assertEquals;

public class Uebung3Test {

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
