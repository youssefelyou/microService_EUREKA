package com.example.eurekaclient.controller;

import com.example.eurekaclient.entity.Client;
import com.example.eurekaclient.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository ;
    @GetMapping("/clients")
    public List chercherClients(){
        return clientRepository.findAll();
    }
    @GetMapping("/client/{id}")
    public Client chercherUnClients (@PathVariable Long id) throws Exception {

        return this.clientRepository.findById(id).orElseThrow(() -> new Exception("Client inexistnt"));

    }
}

