package com.innoq.cdi.instance;

public interface MyInterface {
    default void myMethod() {
        System.err.println("myMethod in " + getClass().getName());
    }
}
