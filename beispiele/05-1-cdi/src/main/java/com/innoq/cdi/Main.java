package com.innoq.cdi;

import com.innoq.cdi.movie.MovieLister;
import org.jboss.weld.environment.se.bindings.Parameters;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class Main {
    private final MovieLister lister;

    @Inject
    public Main(MovieLister lister) {
        this.lister = lister;
    }

    public void onContainerInitialized(@Observes ContainerInitialized event, @Parameters List<String> commandLine) {
         System.err.println("running");

         System.err.println(lister.findByDirector("Francis Ford Coppola"));
    }
}
