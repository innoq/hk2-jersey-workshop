package com.innoq.cdi.extras.aop;

import com.innoq.cdi.instance.Impl;
import com.innoq.cdi.instance.MyInterface;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

@Decorator @Priority(Interceptor.Priority.APPLICATION) @Impl
public class MyInterfaceDecorator implements MyInterface {
    @Delegate @Impl  @Inject
    private MyInterface del;

    @Override
    public void myMethod() {
        System.err.println("Decorator called");
        del.myMethod();
    }
}
