package com.mauriciotogneri.purvey.sample.manual.providers;

import com.mauriciotogneri.purvey.ObjectProvider;
import com.mauriciotogneri.purvey.sample.objects.Timeline;
import com.mauriciotogneri.purvey.sample.objects.Tweeter;
import com.mauriciotogneri.purvey.sample.objects.TweeterApi;
import com.mauriciotogneri.purvey.sample.providers.RootObjectProvider;
import com.mauriciotogneri.purvey.sample.providers.TweeterProvider;

public class DefaultTweeterProvider extends ObjectProvider<RootObjectProvider> implements TweeterProvider
{
	private TweeterApi tweeterApi;
	
	public DefaultTweeterProvider(RootObjectProvider objectProvider)
	{
		super(objectProvider);
	}
	
	@Override
	public TweeterApi getTweeterApi()
	{
		return (this.tweeterApi == null) ? (this.tweeterApi = new TweeterApi(this.provider.getHttpSender())) : this.tweeterApi;
	}
	
	@Override
	public Tweeter getTweeter(String user)
	{
		return new Tweeter(user, getTweeterApi());
	}
	
	@Override
	public Timeline getTimeline(String user)
	{
		return new Timeline(user, getTweeterApi());
	}
}