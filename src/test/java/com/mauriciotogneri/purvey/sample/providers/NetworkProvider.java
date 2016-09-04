package com.mauriciotogneri.purvey.sample.providers;

import com.mauriciotogneri.purvey.Singleton;
import com.mauriciotogneri.purvey.sample.objects.HttpSender;

public interface NetworkProvider
{
    @Singleton
    HttpSender httpSender();
}