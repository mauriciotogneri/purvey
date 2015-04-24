package com.mauriciotogneri.purvey.sample.providers;

import com.mauriciotogneri.dependency.purvey.RootProvider;

public interface RootObjectProvider extends RootProvider, NetworkProvider, TweeterProvider
{
}