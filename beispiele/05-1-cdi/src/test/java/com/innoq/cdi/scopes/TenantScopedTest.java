package com.innoq.cdi.scopes;

import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import javax.enterprise.inject.Default;

public class TenantScopedTest {

    @Rule
    public WeldInitiator weld = WeldInitiator.of(TenantManager.class, TenantScopeContext.class,
            TenantScopedExtension.class, TestBean.class);

    @Test
    public void fooHaengtVomTenantAb() {
        final TenantManager tenantManager = weld.select(TenantManager.class).get();
        tenantManager.setCurrentTenant("alice");
        // der Test in Default-Scope, testBean ist ein Proxy und je
        // nach Tenant, greife ich auf verschiedene Instanzen zu
        final TestBean testBean = weld.select(TestBean.class).get();
        final int a1 = testBean.getValue();

        tenantManager.setCurrentTenant("bob");
        final int b1 = testBean.getValue();

        Assert.assertNotEquals(a1, b1);

        tenantManager.setCurrentTenant("alice");
        final int a2 = testBean.getValue();

        Assert.assertEquals(a1, a2);
    }
}
