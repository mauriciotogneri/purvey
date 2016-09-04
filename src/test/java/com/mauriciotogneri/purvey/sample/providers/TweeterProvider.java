package com.mauriciotogneri.purvey.sample.providers;

import com.mauriciotogneri.purvey.Singleton;
import com.mauriciotogneri.purvey.sample.objects.Timeline;
import com.mauriciotogneri.purvey.sample.objects.Tweeter;
import com.mauriciotogneri.purvey.sample.objects.TweeterApi;

public interface TweeterProvider
{
    @Singleton
    TweeterApi tweeterApi();

    Tweeter tweeter(String user);

    Timeline timeline(String user);
}