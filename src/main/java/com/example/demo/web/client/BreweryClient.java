package com.example.demo.web.client;

import com.example.demo.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {
    private String apihost;
    public String BEER_PATH_V1 = "/api/v1/beer/";

    private final RestTemplate restTemplate;


    public BreweryClient(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID beerId)
    {
        BeerDto beerDto = restTemplate.getForObject(apihost + BEER_PATH_V1 + beerId.toString(), BeerDto.class);
        return beerDto;
    }
    public URI saveNewBeer(BeerDto beerDto)
    {
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
    }
    public void updateBeer(UUID beerId, BeerDto beerDto)
    {
        restTemplate.put(apihost + BEER_PATH_V1 + beerId.toString(), beerDto);
    }
    public void deleteBeer(UUID beerId)
    {
        restTemplate.delete(apihost + BEER_PATH_V1 + beerId.toString());
    }


    public void setApihost(String apihost)
    {
        this.apihost = apihost;
    }
}
