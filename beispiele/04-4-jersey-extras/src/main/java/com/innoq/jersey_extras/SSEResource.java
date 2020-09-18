package com.innoq.jersey_extras;

import javax.annotation.PreDestroy;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseBroadcaster;
import javax.ws.rs.sse.SseEventSink;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Path("sse")
public class SSEResource {
    private final Sse sse;
    private final SseBroadcaster broadcaster;
    private final ScheduledExecutorService es;

    public SSEResource(@Context Sse sse) {
        this.sse = sse;
        broadcaster = sse.newBroadcaster();
        (es = new ScheduledThreadPoolExecutor(1)).scheduleAtFixedRate(this::ping, 2, 2, TimeUnit.SECONDS);
    }

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public void subscribe(@Context SseEventSink subscriber) {
        broadcaster.register(subscriber);
    }

    @PreDestroy
    public void shutdown() {
        broadcaster.close();
        es.shutdown();
    }

    private void ping() {
        broadcaster.broadcast(sse.newEvent("Hello, world"));
    }
}
