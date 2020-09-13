package com.innoq.hk2_extras.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.glassfish.hk2.extras.interception.Interceptor;
import org.jvnet.hk2.annotations.ContractsProvided;

import javax.inject.Singleton;

@Singleton
@Interceptor @Logged
@ContractsProvided(MethodInterceptor.class)
public class LoggingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.err.println("Method " + methodInvocation.getMethod().getName() + " called");
        return methodInvocation.proceed();
    }
}
