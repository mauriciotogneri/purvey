package com.mauriciotogneri.purvey.sample.objects;

import java.util.ArrayList;
import java.util.List;

public class TweeterApi
{
    private final HttpSender sender;

    public TweeterApi(HttpSender sender)
    {
        this.sender = sender;
    }

    public void postTweet(String user, String message)
    {
        sender.send("http://demo3679198.mockable.io/post?user=" + user + "&message=" + message);
    }

    public List<String> get(String user)
    {
        List<String> result = new ArrayList<>();

        String response = sender.send("http://demo3679198.mockable.io/get?user=" + user);

        result.add(response);

        return result;
    }
}