package com.mauriciotogneri.purvey.sample.manual;

import com.mauriciotogneri.purvey.sample.app.Sample;
import com.mauriciotogneri.purvey.sample.manual.providers.DefaultNetworkProvider;
import com.mauriciotogneri.purvey.sample.manual.providers.DefaultTweeterProvider;
import com.mauriciotogneri.purvey.sample.providers.RootObjectProvider;

public class SampleManual
{
    public static void main(String[] args)
    {
        RootObjectProvider objectProvider = new DefaultRootObjectProvider();
        objectProvider.addProvider(new DefaultNetworkProvider());
        objectProvider.addProvider(new DefaultTweeterProvider(objectProvider));

        Sample sample = new Sample();
        sample.run(objectProvider);
    }
}