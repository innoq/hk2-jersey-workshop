package com.innoq.model;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceRegistry {

    private static final ConcurrentMap<Class, Class> SERVICES = new ConcurrentHashMap<>();

    public static <T> T get(Class<T> clazz) {
        final Class<?> service = SERVICES.get(clazz);
        if (service != null) {
            try {
                return clazz.cast(service.newInstance());
            } catch (Exception ex) {
                // best practice ;-)
            }
        }
        return null;
    }

    public static <T,V> void register(Class<T> key, Class<V> value) {
        if (!key.isAssignableFrom(value)) {
            throw new IllegalArgumentException("kann " + value + " nicht als " + key + " benutzen");
        }
        SERVICES.put(key, value);
    }
}
