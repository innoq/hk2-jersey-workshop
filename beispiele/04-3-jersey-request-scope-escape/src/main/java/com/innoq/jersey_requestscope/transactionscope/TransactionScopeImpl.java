package com.innoq.jersey_requestscope.transactionscope;

import org.glassfish.hk2.api.AnnotationLiteral;

public class TransactionScopeImpl extends AnnotationLiteral<TransactionScope> implements TransactionScope {
    public static final TransactionScope INSTANCE = new TransactionScopeImpl();
}
