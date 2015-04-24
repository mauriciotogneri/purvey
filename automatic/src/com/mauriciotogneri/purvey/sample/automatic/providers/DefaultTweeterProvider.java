package com.mauriciotogneri.purvey.sample.automatic.providers;

import com.mauriciotogneri.purvey.ObjectProvider;
import com.mauriciotogneri.purvey.sample.objects.Timeline;
import com.mauriciotogneri.purvey.sample.objects.Tweeter;
import com.mauriciotogneri.purvey.sample.objects.TweeterApi;
import com.mauriciotogneri.purvey.sample.providers.RootObjectProvider;
import com.mauriciotogneri.purvey.sample.providers.TweeterProvider;

public class DefaultTweeterProvider extends ObjectProvider<RootObjectProvider> implements TweeterProvider
{
	public DefaultTweeterProvider(RootObjectProvider objectProvider)
	{
		super(objectProvider);
	}
	
	@Override
	public TweeterApi getTweeterApi()
	{
		return new TweeterApi(this.provider.getHttpSender());
	}
	
	@Override
	public Tweeter getTweeter(String user)
	{
		return new Tweeter(user, this.provider.getTweeterApi());
	}
	
	@Override
	public Timeline getTimeline(String user)
	{
		return new Timeline(user, this.provider.getTweeterApi());
	}
}