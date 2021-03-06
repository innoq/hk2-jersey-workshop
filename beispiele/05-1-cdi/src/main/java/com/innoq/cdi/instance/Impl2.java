package com.innoq.cdi.instance;

import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Impl2 {
    public static class Literal extends AnnotationLiteral<Impl2> implements Impl2 {
        public static final Impl2.Literal INSTANCE = new Literal();
    }
}
