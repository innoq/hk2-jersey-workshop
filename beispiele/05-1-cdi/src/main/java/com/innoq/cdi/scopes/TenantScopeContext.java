package com.innoq.cdi.scopes;

import javax.enterprise.context.spi.AlterableContext;
import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.annotation.Annotation;
import java.util.HashMap;

@Singleton
public class TenantScopeContext implements AlterableContext {

    private final HashMap<String, HashMap<Contextual<?>, TenantScopeInstance>> contexts = new HashMap<>();

    private final TenantManager tenantManager;

    @Inject
    public TenantScopeContext(TenantManager tenantManager) {
        this.tenantManager = tenantManager;
    }

    @Override
    public Class<? extends Annotation> getScope() {
        return TenantScoped.class;
    }

    @Override
    public <T> T get(Contextual<T> contextual, CreationalContext<T> creationalContext) {
        T cached = get(contextual);
        if (cached != null) {
            return cached;
        }
        T t = (T) contextual.create(creationalContext);
        TenantScopeInstance customInstance = new TenantScopeInstance(contextual, creationalContext, t);
        getCurrentContext().put(contextual, customInstance);
        return t;
    }

    @Override
    public <T> T get(Contextual<T> contextual) {
        TenantScopeInstance<T> inst = getCurrentContext().get(contextual);
        return inst == null ? null : inst.instance;
    }

    private HashMap<Contextual<?>, TenantScopeInstance> getCurrentContext() {
        if (tenantManager.getCurrentTenant() == null) throw new IllegalStateException("There is no current tenant");

        HashMap<Contextual<?>, TenantScopeInstance> retVal = contexts.get(tenantManager.getCurrentTenant());
        if (retVal == null) {
            retVal = new HashMap<>();

            contexts.put(tenantManager.getCurrentTenant(), retVal);
        }

        return retVal;
    }

    @Override
    public boolean isActive() {
        return tenantManager.getCurrentTenant() != null;
    }

    @Override
    public void destroy(Contextual<?> contextual) {
        TenantScopeInstance<?> i = getCurrentContext().get(contextual);
        if (i != null) {
            i.destroy();
        }
        getCurrentContext().remove(contextual);
    }

    private static class TenantScopeInstance<T> {
        private final Contextual<T> bean;
        private final CreationalContext<T> ctx;
        private final T instance;

        private TenantScopeInstance(Contextual<T> bean, CreationalContext<T> ctx, T instance) {
            this.bean = bean;
            this.ctx = ctx;
            this.instance = instance;
        }

        private void destroy() {
            bean.destroy(instance, ctx);
        }
    }
}
