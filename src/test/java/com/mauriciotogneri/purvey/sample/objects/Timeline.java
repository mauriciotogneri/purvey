package com.mauriciotogneri.purvey.sample.objects;

import java.util.List;

public class Timeline
{
    private final String user;
    private final TweeterApi api;

    public Timeline(String user, TweeterApi api)
    {
        this.user = user;
        this.api = api;
    }

    public List<String> list()
    {
        return api.list(user);
    }
}