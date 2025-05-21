package com.ironhack.client_service.services;

import com.ironhack.client_service.models.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ClientServiceTest {

    @Autowired
    ClientService clientService;

    @Test
    @DisplayName("El usuario que recibimos es correcto")
    public void getUserByID() {
        Client foundClient = clientService.findClientById(12L);

        assertNotNull(foundClient);
    }
}
