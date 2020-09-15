package com.innoq.jax_rs;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.net.URI;

@PreMatching
public class MyGlobalPreMatchingFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        if ("foo".equals(containerRequestContext.getUriInfo().getPath())) {
            containerRequestContext
                    .setRequestUri(containerRequestContext.getUriInfo().getBaseUriBuilder().path("myresource").build());
        }
    }
}
