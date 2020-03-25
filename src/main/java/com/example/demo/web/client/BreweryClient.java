package com.example.demo.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {
    private String apihost;
    public final String BEER_PATH = "api/v1/beer";
    public void setApihost(String apihost)
    {
        this.apihost = apihost;
    }
}
