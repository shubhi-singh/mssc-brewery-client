package com.example.demo.web.client;

import com.example.demo.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class CustomerClient {
    private String apihost;
    private String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    public CustomerDto getCustomerById(UUID customerId)
    {
        CustomerDto customerDto = restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + customerId.toString(), CustomerDto.class);
        return customerDto;
    }
    public URI saveNewCustomer(CustomerDto customerDto)
    {
        URI id = restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
        return id;
    }
    public void updateCustomer(UUID customerID, CustomerDto customerDto)
    {
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + customerID.toString(), customerDto);
    }
    public  void deleteCustomer(UUID customerID)
    {
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + customerID);
    }
    public void setApihost(String apihost)
    {
        this.apihost = apihost;
    }
}
