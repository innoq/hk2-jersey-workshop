package com.innoq.hk2_extras.operation;

import org.glassfish.hk2.api.Proxiable;

import javax.inject.Scope;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Scope
@Proxiable(proxyForSameScope = false)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyOperationScope {
}
