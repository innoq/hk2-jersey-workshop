package com.innoq.jersey_extras;

import org.glassfish.jersey.server.monitoring.RequestEvent;
import org.glassfish.jersey.server.monitoring.RequestEventListener;

import javax.ws.rs.ext.Provider;

@Provider
public class MyRequestEventListener implements RequestEventListener {
    @Override
    public void onEvent(RequestEvent requestEvent) {
        switch (requestEvent.getType()) {
            case START:
                break;
            case MATCHING_START:
                break;
            case LOCATOR_MATCHED:
                break;
            case SUBRESOURCE_LOCATED:
                break;
            case REQUEST_MATCHED:
                break;
            case REQUEST_FILTERED:
                break;
            case RESOURCE_METHOD_START:
                break;
            case RESOURCE_METHOD_FINISHED:
                break;
            case RESP_FILTERS_START:
                break;
            case RESP_FILTERS_FINISHED:
                break;
            case ON_EXCEPTION:
                break;
            case EXCEPTION_MAPPER_FOUND:
                break;
            case EXCEPTION_MAPPING_FINISHED:
                break;
            case FINISHED:
                break;
        }
    }
}
