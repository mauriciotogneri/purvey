package com.mauriciotogneri.dependency.purvey;

public interface RootProvider
{
	void addProvider(ObjectProvider<?> provider);
}