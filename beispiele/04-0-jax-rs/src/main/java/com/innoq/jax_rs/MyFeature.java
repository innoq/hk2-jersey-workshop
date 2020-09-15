package com.innoq.jax_rs;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class MyFeature implements Feature {
    @Override
    public boolean configure(FeatureContext featureContext) {
        featureContext.register(MyGlobalFilter.class);
        featureContext.register(MyGlobalPreMatchingFilter.class);
        featureContext.register(MySelectiveFilter.class);
        return true;
    }
}
