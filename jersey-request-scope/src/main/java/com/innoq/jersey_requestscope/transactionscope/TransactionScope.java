package com.innoq.jersey_requestscope.transactionscope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Scope;

import org.glassfish.hk2.api.Proxiable;

@Scope
@Proxiable(proxyForSameScope = false)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TransactionScope {
}
