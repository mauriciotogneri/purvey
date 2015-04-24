package com.mauriciotogneri.purvey.sample.objects;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpSender
{
	public String send(String uri)
	{
		StringBuilder builder = new StringBuilder();
		
		try
		{
			URL url = new URL(uri);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			
			while ((line = reader.readLine()) != null)
			{
				builder.append(line);
				builder.append('\r');
			}
			
			reader.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		String result = builder.toString();
		
		System.out.println(">>> " + uri);
		System.out.println("<<< " + result);
		
		return result;
	}
}