package com.innoq.uebung1;

import com.innoq.uebung1.beans.GreetingService;
import org.junit.Test;

public class Uebung1Test {

    GreetingService greetingService;

    @Test
    public void testGreet() {
        greetingService.greetPerson();
    }
}
