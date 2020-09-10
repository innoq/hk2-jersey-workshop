package com.innoq.uebung1.beans;

import javax.inject.Inject;
import javax.inject.Named;
import org.jvnet.hk2.annotations.Service;

@Service
public class DefaultPersonService implements PersonService {
    private final String firstName;

    @Inject
    public DefaultPersonService(@Named("firstname") String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }
}
