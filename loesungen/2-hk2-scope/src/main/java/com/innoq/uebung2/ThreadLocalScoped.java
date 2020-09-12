package com.innoq.uebung2;

import org.glassfish.hk2.api.Proxiable;

import javax.inject.Scope;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Scope
@Proxiable
@Retention(RUNTIME)
@Target( { TYPE, METHOD })
public @interface ThreadLocalScoped {
}
