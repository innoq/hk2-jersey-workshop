package com.innoq.uebung2;

import org.glassfish.hk2.api.ActiveDescriptor;
import org.glassfish.hk2.api.Context;
import org.glassfish.hk2.api.ServiceHandle;

import javax.inject.Singleton;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class ThreadLocalScopedContext implements Context<ThreadLocalScoped> {

    private static final ThreadLocal<Map<ActiveDescriptor<?>, Object>> mappings =
            new ThreadLocal<Map<ActiveDescriptor<?>, Object>>() {
                @Override
                protected Map<ActiveDescriptor<?>, Object> initialValue() {
                    return new HashMap<>();
                }
            };

    @Override
    public Class<? extends Annotation> getScope() {
        return ThreadLocalScoped.class;
    }

    @Override
    public <U> U findOrCreate(ActiveDescriptor<U> activeDescriptor, ServiceHandle<?> serviceHandle) {
        Object retVal = mappings.get().get(activeDescriptor);
        if (retVal == null) {
            retVal = activeDescriptor.create(serviceHandle);

            mappings.get().put(activeDescriptor, retVal);
        }

        return (U) retVal;
    }

    @Override
    public boolean containsKey(ActiveDescriptor<?> activeDescriptor) {
        return mappings.get().containsKey(activeDescriptor);
    }

    @Override
    public void destroyOne(ActiveDescriptor<?> activeDescriptor) {
        mappings.get().remove(activeDescriptor);
    }

    @Override
    public boolean supportsNullCreation() {
        return false;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void shutdown() {

    }
}
