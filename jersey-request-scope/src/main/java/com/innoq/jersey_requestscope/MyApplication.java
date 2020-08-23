package com.innoq.jersey_requestscope;

import com.innoq.jersey_requestscope.domain.*;

import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

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

                    bindFactory(MovieFinderFactory.class)
                        .to(MovieFinder.class)
                        .in(RequestScoped.class)
                        ;

                    /*
                    bindFactory(ThreadLocalMovieFinderFactory.class)
                        .to(MovieFinder.class)
                        ;
                    */
                }
            });
    }

}

