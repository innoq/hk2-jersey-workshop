package com.innoq.jersey_extras;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.process.Inflector;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.model.Resource;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.MediaType;

public class MyApplication extends ResourceConfig {
    public MyApplication() {
        packages("org.glassfish.jersey.examples.jackson").register(JacksonFeature.class);

        Resource.Builder rb = Resource.builder().path("viacode");
        rb.addMethod().httpMethod("GET").produces(MediaType.TEXT_PLAIN)
                .handledBy( new Inflector<ContainerRequestContext, String>() {

                    @Override
                    public String apply(ContainerRequestContext ctx) {
                        final String n = ctx.getUriInfo().getQueryParameters().getFirst("name");
                        return "Hallo, " + (n == null ? "world" : n);
                    }
                })
                .build();
        registerResources(rb.build());

        property(ServerProperties.MONITORING_STATISTICS_ENABLED, true);

        registerClasses(SSEResource.class, Monitoring.class);
    }
}
