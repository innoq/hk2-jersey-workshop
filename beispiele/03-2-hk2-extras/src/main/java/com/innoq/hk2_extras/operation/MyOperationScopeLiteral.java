package com.innoq.hk2_extras.operation;

import org.glassfish.hk2.api.AnnotationLiteral;

public class MyOperationScopeLiteral extends AnnotationLiteral<MyOperationScope> implements MyOperationScope {
    public static final MyOperationScope INSTANCE = new MyOperationScopeLiteral();
}
