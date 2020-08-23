package com.innoq.jersey_requestscope;

import com.innoq.jersey_requestscope.domain.MovieSearcher;
import com.innoq.jersey_requestscope.domain.MovieSearcherJob;
import com.innoq.jersey_requestscope.transactionscope.TransactionScopeImpl;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Provider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.hk2.extras.operation.OperationHandle;
import org.glassfish.hk2.extras.operation.OperationManager;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource-op")
public class MyResourceOp {

    private MovieSearcher searcher;

    @Inject
    public MyResourceOp(final MovieSearcher searcher, final Provider<MovieSearcherJob> jobProvider,
                      final OperationManager opMan) {
        this.searcher = searcher;
        EX.scheduleAtFixedRate(() -> {
                final OperationHandle<?> oph = opMan.createOperation(TransactionScopeImpl.INSTANCE);
                oph.resume();
                try {
                    jobProvider.get().run();
                } finally {
                    oph.closeOperation();
                }
            },
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
