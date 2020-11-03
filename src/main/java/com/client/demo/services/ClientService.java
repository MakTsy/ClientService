package com.client.demo.services;


import com.client.demo.entities.Client;
import com.client.demo.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public void addClient(Client client) {
        this.clientRepository.save(client);
    }


    @Transactional
    public Client getCliennt(UUID id) {
        return this.clientRepository.findById(id).orElseThrow();
    }

}