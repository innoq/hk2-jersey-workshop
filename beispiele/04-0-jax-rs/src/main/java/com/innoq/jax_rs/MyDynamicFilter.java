package com.innoq.jax_rs;

import javax.ws.rs.container.*;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class MyDynamicFilter implements DynamicFeature {

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext featureContext) {
        if (MyResource.class.equals(resourceInfo.getResourceClass())
                && resourceInfo.getResourceMethod().getName().contains("dynamic")
        ) {
            featureContext.register(ActualFilter.class);
        }
    }

    public static class ActualFilter implements ContainerResponseFilter {

        @Override
        public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
            System.err.println("MyDynamicFilter called");
        }
    }
}
