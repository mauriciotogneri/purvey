package com.mauriciotogneri.purvey;

public class ObjectProvider<T>
{
	protected final T provider;
	
	public ObjectProvider(T provider)
	{
		this.provider = provider;
	}
	
	public ObjectProvider()
	{
		this(null);
	}
}