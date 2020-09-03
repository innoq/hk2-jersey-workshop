package com.innoq.jersey_requestscope;

import com.innoq.jersey_requestscope.domain.*;
import com.innoq.jersey_requestscope.transactionscope.*;

import org.glassfish.hk2.api.Context;
import org.glassfish.hk2.extras.operation.OperationContext;
import org.glassfish.hk2.extras.operation.OperationManager;
import org.glassfish.hk2.extras.operation.internal.OperationManagerImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.hk2.utilities.reflection.ParameterizedTypeImpl;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.ResourceConfig;

import java.lang.reflect.Type;
import javax.inject.Singleton;

public class MyApplication extends ResourceConfig {

    public MyApplication() {
        packages("com.innoq.jersey_requestscope");
        register(new AbstractBinder() {
                @Override
                protected void configure() {

                    bind(MovieSearcherImpl.class)
                        .to(MovieSearcher.class);
                    bind(MovieSearcherJob.class)
                        .to(MovieSearcherJob.class);

                    /*
                    bindFactory(MovieFinderFactory.class)
                        .to(MovieFinder.class)
                        .in(RequestScoped.class)
                        ;
                    */

                    /*
                    bindFactory(ThreadLocalMovieFinderFactory.class)
                        .to(MovieFinder.class)
                        ;
                    */

                    bind(TransactionScopeContext.class)
                        .to(OperationContext.class)
                        .to(new ParameterizedTypeImpl(Context.class, new Type[] { TransactionScope.class }))
                        .in(Singleton.class)
                        ;
                    bind(OperationManagerImpl.class)
                        .to(OperationManager.class)
                        .in(Singleton.class)
                        ;
                    bindFactory(MovieFinderFactory.class)
                        .to(MovieFinder.class)
                        .in(TransactionScope.class)
                        ;
                }
            });
    }

}

