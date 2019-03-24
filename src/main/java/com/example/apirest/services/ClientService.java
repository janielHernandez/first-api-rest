package com.example.apirest.services;

import com.example.apirest.dao.IClientDao;
import com.example.apirest.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientService implements IClientService {


    @Autowired
    private IClientDao dao;

    @Override
    @Transactional
    public List<Client> findAll() {
        return (List<Client>) dao.findAll();
    }

    @Override
    @Transactional
    public Client save(Client c) {
        return dao.save(c);
    }

    @Override
    @Transactional
    public Client findById(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
            dao.deleteById( id );
    }
}
