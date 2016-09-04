package com.mauriciotogneri.purvey.sample.app;

import com.mauriciotogneri.purvey.sample.objects.Timeline;
import com.mauriciotogneri.purvey.sample.objects.Tweeter;
import com.mauriciotogneri.purvey.sample.providers.RootObjectProvider;

import java.util.List;

public class Sample
{
    public void run(RootObjectProvider objectProvider)
    {
        Tweeter tweeter = objectProvider.tweeter("Max");
        tweeter.tweet("This_is_a_message!");

        Timeline timeline = objectProvider.timeline("Max");
        List<String> messages = timeline.list();
        System.out.println(messages);
    }
}