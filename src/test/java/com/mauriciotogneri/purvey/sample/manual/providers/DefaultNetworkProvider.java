package com.mauriciotogneri.purvey.sample.manual.providers;

import com.mauriciotogneri.purvey.ObjectProvider;
import com.mauriciotogneri.purvey.sample.objects.HttpSender;
import com.mauriciotogneri.purvey.sample.providers.NetworkProvider;

public class DefaultNetworkProvider extends ObjectProvider<Void> implements NetworkProvider
{
    private HttpSender httpSender;

    @Override
    public HttpSender getHttpSender()
    {
        return (httpSender == null) ? (httpSender = new HttpSender()) : httpSender;
    }
}