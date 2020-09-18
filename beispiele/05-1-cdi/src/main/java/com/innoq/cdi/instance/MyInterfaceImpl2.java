package com.innoq.cdi.instance;

import com.innoq.cdi.extras.aop.MyIntercepted;

@Impl2
@MyIntercepted
public class MyInterfaceImpl2 implements MyInterface {
    @Override
    public void myMethod() {
        System.err.println("myMethod in " + getClass().getName());
    }
}
