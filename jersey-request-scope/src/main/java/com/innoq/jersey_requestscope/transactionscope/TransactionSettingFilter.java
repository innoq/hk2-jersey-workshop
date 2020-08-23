package com.innoq.jersey_requestscope.transactionscope;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.glassfish.hk2.extras.operation.OperationHandle;
import org.glassfish.hk2.extras.operation.OperationManager;

@Provider
public class TransactionSettingFilter
    implements ContainerRequestFilter, ContainerResponseFilter {

    private static final String OPERATION_PROP = "operationHandle";

    private final OperationManager manager;

    @Inject
    public TransactionSettingFilter(final OperationManager manager) {
        this.manager = manager;
    }

    @Override
    public void filter(ContainerRequestContext req) {
        final OperationHandle<?> oph = manager.createAndStartOperation(TransactionScopeImpl.INSTANCE);
        req.setProperty(OPERATION_PROP, oph);
    }

    @Override
    public void filter(ContainerRequestContext req, ContainerResponseContext res) {
        final Object oph = req.getProperty(OPERATION_PROP);
        if (oph != null) {
            ((OperationHandle<?>) oph).closeOperation();
        }
    }
}
