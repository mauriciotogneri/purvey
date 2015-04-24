package com.mauriciotogneri.purvey.sample.app;

import java.util.List;
import com.mauriciotogneri.purvey.sample.objects.Timeline;
import com.mauriciotogneri.purvey.sample.objects.Tweeter;
import com.mauriciotogneri.purvey.sample.providers.RootObjectProvider;

public class Sample
{
	public void run(RootObjectProvider objectProvider)
	{
		Tweeter tweeter = objectProvider.getTweeter("Max");
		tweeter.tweet("This_is_a_message!");
		
		Timeline timeline = objectProvider.getTimeline("Max");
		List<String> messages = timeline.get();
		System.out.println(messages);
	}
}