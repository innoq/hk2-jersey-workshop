package com.innoq.cdi.scopes;

import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Scope;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Scope
@Retention(RUNTIME)
@Target( { TYPE, METHOD })
public @interface TenantScoped {
    public static class Literal extends AnnotationLiteral<TenantScoped> implements TenantScoped {
        public static final TenantScoped INSTANCE = new Literal();
    }
}
