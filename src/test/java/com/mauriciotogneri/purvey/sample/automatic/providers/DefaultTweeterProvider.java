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
    public TweeterApi tweeterApi()
    {
        return new TweeterApi(provider.httpSender());
    }

    @Override
    public Tweeter tweeter(String user)
    {
        return new Tweeter(user, provider.tweeterApi());
    }

    @Override
    public Timeline timeline(String user)
    {
        return new Timeline(user, provider.tweeterApi());
    }
}