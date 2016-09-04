package com.mauriciotogneri.purvey.sample.automatic.providers;

import com.mauriciotogneri.purvey.ObjectProvider;
import com.mauriciotogneri.purvey.sample.objects.HttpSender;
import com.mauriciotogneri.purvey.sample.providers.NetworkProvider;

public class DefaultNetworkProvider extends ObjectProvider<Void> implements NetworkProvider
{
    @Override
    public HttpSender httpSender()
    {
        return new HttpSender();
    }
}