package com.innoq.hk2_extras.aop;

import org.glassfish.hk2.extras.interception.InterceptionBinder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@InterceptionBinder
public @interface Logged {
}
