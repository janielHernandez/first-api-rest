package com.example.apirest.controllers;


import com.example.apirest.consts.ErrorManage;
import com.example.apirest.entities.Client;
import com.example.apirest.services.IClientService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/first")
public class ClientRestController {

    private Log log = LogFactory.getLog(ClientRestController.class);

    @Autowired
    private IClientService service;

    @GetMapping("/client")
    public List<Client> listClient(){
        return service.findAll();
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Integer id){
        try {
            Client c =  service.findById(id);
            if (c == null){
                return ErrorManage.clientNotFound(id);
            }
            return new ResponseEntity<>(c, HttpStatus.OK);
        } catch (DataAccessException e){
            log.error(e);
            return ErrorManage.connectingToDB(e.getMostSpecificCause().getMessage());
        }
    }


    @PostMapping("/client")
    public ResponseEntity<?> createClient(@RequestBody Client client){
         Client c;
        try{
            c = service.save(client);
        } catch (DataAccessException e){
            log.error(e);
            return ErrorManage.insertingInDB(e.getMostSpecificCause().getMessage());
        }
        return new ResponseEntity<>(c, HttpStatus.CREATED);

    }

    @PutMapping("/client/{id}")
    public ResponseEntity<?> update(@RequestBody Client client, @PathVariable Integer id){

        try {
            Client c = service.findById(id);
            if (c == null) {
                return ErrorManage.clientNotFound(id);
            }
            c.update(client);
            Client uc =  service.save(c);
            return new ResponseEntity<>(uc, HttpStatus.CREATED);
        } catch (DataAccessException e){
            log.error(e);
            return ErrorManage.updatingInDB(e.getMostSpecificCause().getMessage());
        }
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){

        try{
            service.delete( id );

            Map<String, Object> map =  new HashMap<>();
            map.put("message", "Client was deleting successfully");
            return  new ResponseEntity<>(map, HttpStatus.NO_CONTENT);
        } catch (DataAccessException e){
            log.error(e);
            return ErrorManage.deletingInDB(e.getMostSpecificCause().getMessage());
        }


    }
}
