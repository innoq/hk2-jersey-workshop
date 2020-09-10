package com.innoq.uebung1.beans;

import javax.inject.Inject;
import org.jvnet.hk2.annotations.Service;

@Service
public class GreetingService {

    private final PersonService personService;

    @Inject
    public GreetingService(final PersonService personService) {
        this.personService = personService;
    }

    public String greetPerson() {
        return "Hallo, " + personService.getFirstName();
    }
}
