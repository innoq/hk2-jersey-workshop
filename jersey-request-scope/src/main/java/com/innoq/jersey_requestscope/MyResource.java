package com.innoq.jersey_requestscope;

import com.innoq.jersey_requestscope.domain.MovieSearcher;
import com.innoq.jersey_requestscope.domain.MovieSearcherJob;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Provider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    private MovieSearcher searcher;

    @Inject
    public MyResource(final MovieSearcher searcher, final Provider<MovieSearcherJob> jobProvider) {
        this.searcher = searcher;
        EX.scheduleAtFixedRate(() -> jobProvider.get().run(),
            0, 5, TimeUnit.SECONDS);
    }

    private static final ScheduledThreadPoolExecutor EX = new ScheduledThreadPoolExecutor(1);

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return String.valueOf(searcher.findByDirector("Stanley Kubrick"));
    }
}
