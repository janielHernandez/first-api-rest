package com.example.apirest.services;

import com.example.apirest.entities.Client;

import java.util.List;

public interface IClientService {

    List<Client> findAll();

    Client save(Client c);

    Client findById(Integer id);

    void delete(Integer c);

}
