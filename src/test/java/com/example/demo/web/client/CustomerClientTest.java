package com.example.demo.web.client;

import com.example.demo.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerClientTest {

    @Autowired
    private CustomerClient customerClient;
    @Test
    void getCustomerById() {
        UUID customerID = UUID.randomUUID();
        CustomerDto customerDto = customerClient.getCustomerById(customerID);
        assertNotNull(customerDto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Customer Mock").build();
        URI uri = customerClient.saveNewCustomer(customerDto);
        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Customer Mock 1").id(UUID.randomUUID()).build();
        customerClient.updateCustomer(customerDto.getId(), customerDto);
    }

    @Test
    void deleteCustomer() {
        UUID customerId = UUID.randomUUID();
        customerClient.deleteCustomer(customerId);
    }
}