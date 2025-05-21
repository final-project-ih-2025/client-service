package com.ironhack.client_service.controllers;


import com.ironhack.client_service.exceptions.ClientNotFoundException;
import com.ironhack.client_service.models.Client;
import com.ironhack.client_service.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {

        try {
            Client foundClient = clientService.findClientById(id);
            return new ResponseEntity<>(foundClient, HttpStatus.OK);
        } catch (ClientNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

}
