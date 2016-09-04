package com.mauriciotogneri.purvey;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Singleton
{
    enum Type
    {
        RETURN_TYPE,
        METHOD
    }

    Type type() default Type.RETURN_TYPE;
}