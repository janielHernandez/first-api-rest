package com.example.apirest.dao;

import com.example.apirest.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface IClientDao extends CrudRepository<Client, Integer> {
}
