package com.innoq.jax_rs;

import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<>(Arrays.asList(MyResource.class, MyExceptionMapper.class, MyFeature.class, MyDynamicFilter.class));
    }
}
