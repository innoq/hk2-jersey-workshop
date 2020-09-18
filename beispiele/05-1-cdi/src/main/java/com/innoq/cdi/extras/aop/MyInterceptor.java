package com.innoq.cdi.extras.aop;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@MyIntercepted
@Interceptor @Priority(Interceptor.Priority.APPLICATION)
public class MyInterceptor {
    @AroundInvoke
    public Object doMyStuff(InvocationContext ctx) throws Exception {
        System.err.println("Interceptor vorher");
        Object o = ctx.proceed();
        System.err.println("Interceptor nachher");
        return o;
    }
}
