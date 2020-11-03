package com.client.demo.controllers;


import com.client.demo.entities.Client;
import com.client.demo.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/newOne")
    public ResponseEntity<UUID> createClient(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        Client client = new Client(name, surname);
        this.clientService.addClient(client);
        return new ResponseEntity<UUID>( client.getIdClient(), HttpStatus.OK);
    }
}
