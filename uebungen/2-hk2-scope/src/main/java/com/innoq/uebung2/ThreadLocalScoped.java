package com.innoq.uebung2;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

// TODO das soll eine Scope Annotation werden
@Retention(RUNTIME)
@Target( { TYPE, METHOD })
public @interface ThreadLocalScoped {
}
