package com.innoq.jersey_requestscope.transactionscope;

import java.lang.annotation.Annotation;

import javax.inject.Singleton;

import org.glassfish.hk2.extras.operation.OperationContext;

@Singleton
public class TransactionScopeContext extends OperationContext<TransactionScope> {
    @Override
    public Class<? extends Annotation> getScope() {
        return TransactionScope.class;
    }
}
