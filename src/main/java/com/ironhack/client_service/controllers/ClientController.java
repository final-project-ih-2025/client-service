package com.ironhack.client_service.controllers;


import com.ironhack.client_service.dtos.ActivityDTO;
import com.ironhack.client_service.exceptions.ClientNotFoundException;
import com.ironhack.client_service.feignclients.ActivityFeignClient;
import com.ironhack.client_service.models.Client;
import com.ironhack.client_service.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    ActivityFeignClient activityFeignClient;

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {

        try {
            Client foundClient = clientService.findClientById(id);


            ActivityDTO foundActivity = activityFeignClient.getActivityById(foundClient.getActivityId());
            System.out.println(foundActivity);

            Map<String, Object> response = new HashMap<>();
            response.put("Client", foundClient);
            response.put("Activity", foundActivity);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ClientNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

}
