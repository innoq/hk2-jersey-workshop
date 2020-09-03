package com.example;

import com.example.model.MovieLister;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@RequestScoped
@Path("myresource")
public class MyResource {

    private final MovieLister lister;
    
    @Inject
    public MyResource(final MovieLister lister) {
        this.lister = lister;
    }
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return lister.findByDirector("Francis Ford Coppola").get(0).getTitle();
    }
}
