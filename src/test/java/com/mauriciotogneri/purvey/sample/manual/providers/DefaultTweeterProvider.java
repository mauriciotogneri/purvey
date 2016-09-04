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
    public TweeterApi tweeterApi()
    {
        return (tweeterApi == null) ? (tweeterApi = new TweeterApi(provider.httpSender())) : tweeterApi;
    }

    @Override
    public Tweeter tweeter(String user)
    {
        return new Tweeter(user, tweeterApi());
    }

    @Override
    public Timeline timeline(String user)
    {
        return new Timeline(user, tweeterApi());
    }
}