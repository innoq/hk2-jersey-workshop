package com.innoq.cdi.scopes;

import org.jboss.weld.contexts.CreationalContextImpl;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.*;
import java.util.Set;

public class TenantScopedExtension implements Extension {
    public void addScope(@Observes final BeforeBeanDiscovery event) {
        event.addScope(TenantScoped.class, true, false);
    }
    public void registerContext(@Observes final AfterBeanDiscovery event, BeanManager manager) {
        Set<Bean<?>> beans = manager.getBeans(TenantScopeContext.class);
        Bean<TenantScopeContext> ctxBean = (Bean<TenantScopeContext>) beans.iterator().next();
        event.addContext(ctxBean.create(new CreationalContextImpl<TenantScopeContext>(ctxBean)));
    }
}
