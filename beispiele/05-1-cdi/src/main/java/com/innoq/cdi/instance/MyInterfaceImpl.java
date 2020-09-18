package com.innoq.cdi.instance;

import javax.enterprise.inject.Typed;

@Impl
@Typed({MyInterface.class})
public class MyInterfaceImpl implements MyInterface, AnotherInterface {
}
