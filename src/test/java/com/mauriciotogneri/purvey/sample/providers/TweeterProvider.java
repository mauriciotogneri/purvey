package com.mauriciotogneri.purvey.sample.providers;

import com.mauriciotogneri.purvey.Singleton;
import com.mauriciotogneri.purvey.sample.objects.Timeline;
import com.mauriciotogneri.purvey.sample.objects.Tweeter;
import com.mauriciotogneri.purvey.sample.objects.TweeterApi;

public interface TweeterProvider
{
    @Singleton
    TweeterApi getTweeterApi();

    Tweeter getTweeter(String user);

    Timeline getTimeline(String user);
}