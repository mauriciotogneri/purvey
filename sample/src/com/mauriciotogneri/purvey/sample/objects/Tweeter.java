package com.mauriciotogneri.purvey.sample.objects;

public class Tweeter
{
	private final String user;
	private final TweeterApi api;
	
	public Tweeter(String user, TweeterApi api)
	{
		this.user = user;
		this.api = api;
	}
	
	public void tweet(String message)
	{
		this.api.postTweet(this.user, message);
	}
}