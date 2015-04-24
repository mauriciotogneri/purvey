package com.mauriciotogneri.purvey.sample.manual;

import com.mauriciotogneri.purvey.ObjectProvider;
import com.mauriciotogneri.purvey.sample.objects.HttpSender;
import com.mauriciotogneri.purvey.sample.objects.Timeline;
import com.mauriciotogneri.purvey.sample.objects.Tweeter;
import com.mauriciotogneri.purvey.sample.objects.TweeterApi;
import com.mauriciotogneri.purvey.sample.providers.NetworkProvider;
import com.mauriciotogneri.purvey.sample.providers.RootObjectProvider;
import com.mauriciotogneri.purvey.sample.providers.TweeterProvider;

public class DefaultRootObjectProvider implements RootObjectProvider
{
	private NetworkProvider networkProvider;
	private TweeterProvider tweeterProvider;
	
	@Override
	public void addProvider(ObjectProvider<?> provider)
	{
		if (provider instanceof NetworkProvider)
		{
			this.networkProvider = (NetworkProvider)provider;
		}
		else if (provider instanceof TweeterProvider)
		{
			this.tweeterProvider = (TweeterProvider)provider;
		}
	}
	
	@Override
	public Tweeter getTweeter(String user)
	{
		return this.tweeterProvider.getTweeter(user);
	}
	
	@Override
	public TweeterApi getTweeterApi()
	{
		return this.tweeterProvider.getTweeterApi();
	}
	
	@Override
	public Timeline getTimeline(String user)
	{
		return this.tweeterProvider.getTimeline(user);
	}
	
	@Override
	public HttpSender getHttpSender()
	{
		return this.networkProvider.getHttpSender();
	}
}