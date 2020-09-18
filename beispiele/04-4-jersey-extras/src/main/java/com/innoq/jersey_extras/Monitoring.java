package com.innoq.jersey_extras;

import org.glassfish.jersey.server.monitoring.MonitoringStatistics;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("monitoring")
public class Monitoring {

    private final Provider<MonitoringStatistics> stats;

    @Inject
    public Monitoring(Provider<MonitoringStatistics> stats) {
        this.stats = stats;
    }

    @GET
    public String test() {
        MonitoringStatistics s = stats.get();
        return "Hello";
    }
}
