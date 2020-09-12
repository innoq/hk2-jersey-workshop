package com.innoq.hk2_extras.operation;

import org.glassfish.hk2.extras.operation.OperationContext;

import javax.inject.Singleton;
import java.lang.annotation.Annotation;

@Singleton
public class MyOperationContext extends OperationContext<MyOperationScope> {
    @Override
    public Class<? extends Annotation> getScope() {
        return MyOperationScope.class;
    }
}
