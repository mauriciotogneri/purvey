package com.mauriciotogneri.purvey.sample.automatic;

import com.mauriciotogneri.purvey.ProviderManager;
import com.mauriciotogneri.purvey.sample.app.Example;
import com.mauriciotogneri.purvey.sample.automatic.providers.DefaultNetworkProvider;
import com.mauriciotogneri.purvey.sample.automatic.providers.DefaultTweeterProvider;
import com.mauriciotogneri.purvey.sample.providers.RootObjectProvider;

public class TestAutomatic
{
	public static void main(String[] args)
	{
		RootObjectProvider objectProvider = ProviderManager.get(RootObjectProvider.class);
		objectProvider.addProvider(new DefaultNetworkProvider());
		objectProvider.addProvider(new DefaultTweeterProvider(objectProvider));
		
		Example example = new Example();
		example.run(objectProvider);
	}
}