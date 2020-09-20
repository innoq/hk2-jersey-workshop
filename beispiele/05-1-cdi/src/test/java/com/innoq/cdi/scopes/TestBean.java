package com.innoq.cdi.scopes;

import java.security.SecureRandom;

@TenantScoped
public class TestBean {
    private final int value = new SecureRandom().nextInt();

    public int getValue() {
        return value;
    }
}