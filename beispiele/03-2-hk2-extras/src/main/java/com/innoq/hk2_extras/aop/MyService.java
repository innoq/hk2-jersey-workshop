package com.innoq.hk2_extras.aop;

import org.glassfish.hk2.extras.interception.Intercepted;
import org.jvnet.hk2.annotations.Service;

@Service
@Intercepted
public class MyService {

    public void foo() {
    }

    @Logged
    public void bar() {
    }
}
