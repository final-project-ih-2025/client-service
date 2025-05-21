package com.ironhack.client_service.services;

import com.ironhack.client_service.exceptions.ClientNotFoundException;
import com.ironhack.client_service.models.Client;
import com.ironhack.client_service.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired // inyección por campo (básica)
    ClientRepository clientRepository;

    // recibir un usuario por ID
    public Client findClientById(Long id) throws ClientNotFoundException {
        Optional<Client> foundClient = clientRepository.findById(id);

        if (foundClient.isPresent()) {
            return foundClient.get();
        } else {
            throw new ClientNotFoundException("Cliente no encontrado");
        }
    }
}
