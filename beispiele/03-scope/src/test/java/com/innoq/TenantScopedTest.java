package com.innoq;

import org.junit.Test;
import org.junit.Assert;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

public class TenantScopedTest {

    @Test
    public void fooHaengtVomTenantAb() {
        final ServiceLocator locator = ServiceLocatorFactory.getInstance().create("tenant");
        ServiceLocatorUtilities.addClasses(locator, TenantManager.class, TenantScopedContext.class, TestBean.class);
        final TenantManager tenantManager = locator.getService(TenantManager.class);

        tenantManager.setCurrentTenant("alice");
        // der Test in Default-Scope, testBean ist ein Proxy und je
        // nach Tenant, greife ich auf verschiedene Instanzen zu
        final TestBean testBean = locator.getService(TestBean.class);
        final int a1 = testBean.getValue();
        
        tenantManager.setCurrentTenant("bob");
        final int b1 = testBean.getValue();

        Assert.assertNotEquals(a1, b1);

        tenantManager.setCurrentTenant("alice");
        final int a2 = testBean.getValue();

        Assert.assertEquals(a1, a2);
    }

}
