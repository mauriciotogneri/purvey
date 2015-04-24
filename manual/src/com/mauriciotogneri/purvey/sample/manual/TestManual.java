package com.mauriciotogneri.purvey.sample.manual;

import com.mauriciotogneri.purvey.sample.app.Example;
import com.mauriciotogneri.purvey.sample.manual.providers.DefaultNetworkProvider;
import com.mauriciotogneri.purvey.sample.manual.providers.DefaultTweeterProvider;
import com.mauriciotogneri.purvey.sample.providers.RootObjectProvider;

public class TestManual
{
	public static void main(String[] args)
	{
		RootObjectProvider objectProvider = new DefaultRootObjectProvider();
		objectProvider.addProvider(new DefaultNetworkProvider());
		objectProvider.addProvider(new DefaultTweeterProvider(objectProvider));
		
		Example example = new Example();
		example.run(objectProvider);
	}
}