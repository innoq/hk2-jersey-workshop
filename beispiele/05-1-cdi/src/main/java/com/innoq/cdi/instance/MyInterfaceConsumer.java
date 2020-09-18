package com.innoq.cdi.instance;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public class MyInterfaceConsumer {
    private final Instance<MyInterface> inst;

    @Inject
    public MyInterfaceConsumer(@Any Instance<MyInterface> inst) {
        this.inst = inst;
    }

    public void showOff() {
        System.err.println("Alle MyInterfaces");
        for (MyInterface i : inst) {
            System.err.println(i.getClass());
        }

        System.err.println("Select: " + inst.select(new ImplQualifier()).get().getClass());

        inst.select(new ImplQualifier()).get().myMethod();

        System.err.println("Intercepted");
        inst.select(Impl2.Literal.INSTANCE).get().myMethod();
    }
}
