package com.mauriciotogneri.purvey.sample.providers;

import com.mauriciotogneri.dependency.purvey.Singleton;
import com.mauriciotogneri.purvey.sample.objects.HttpSender;

public interface NetworkProvider
{
	@Singleton
	HttpSender getHttpSender();
}