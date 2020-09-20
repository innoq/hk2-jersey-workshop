package com.innoq.cdi.scopes;

import javax.inject.Singleton;

@Singleton
public class TenantManager {
    private String currentTenant;

    public void setCurrentTenant(String currentTenant) {
        this.currentTenant = currentTenant;
    }

    public String getCurrentTenant() {
        return currentTenant;
    }
}
