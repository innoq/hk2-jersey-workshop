package com.innoq.hk2_extras.config;

import org.glassfish.hk2.configuration.api.Configured;
import org.glassfish.hk2.configuration.api.ConfiguredBy;
import org.jvnet.hk2.annotations.Service;

@Service
@ConfiguredBy("MyBean")
public class MyServiceImpl implements MyService {
    @Configured
    private String text;

    @Configured(value = "number")
    private int num;

    @Override
    public String whoAreYou() {
        return toString();
    }

    @Override
    public String toString() {
        return "MyService{" +
                "text='" + text + '\'' +
                ", num=" + num +
                '}';
    }
}
