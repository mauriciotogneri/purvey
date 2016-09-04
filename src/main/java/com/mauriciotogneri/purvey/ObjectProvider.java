package com.mauriciotogneri.purvey;

public class ObjectProvider<T>
{
    protected final T provider;

    protected ObjectProvider(T provider)
    {
        this.provider = provider;
    }

    protected ObjectProvider()
    {
        this(null);
    }
}