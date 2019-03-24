package com.example.apirest.consts;

import com.example.apirest.controllers.ClientRestController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ErrorManage {

    private static Log log = LogFactory.getLog(ErrorManage.class);

    public static final String LOOK_CLIENT_ERROR = "Error looking for client with id ";
    public static final String CONNECTING_DB_ERROR = "Error connecting with DB";
    public static final String INSERT_ERROR = "Error inserting in DB";
    public static final String UPDATE_ERROR = "Error updating in DB";
    public static final String DELETE_ERROR = "Error deleting in DB";


    public static ResponseEntity<?> clientNotFound(Integer id){

        log.error(ErrorManage.LOOK_CLIENT_ERROR + id.toString());
        Map<String, Object> map  = new HashMap<>();
        map.put("message", ErrorManage.LOOK_CLIENT_ERROR  + id.toString() );
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);

    }

    public static ResponseEntity<?> connectingToDB(String error){

        log.error(ErrorManage.CONNECTING_DB_ERROR);
        Map<String, Object> map  = new HashMap<>();
        map.put("message", ErrorManage.CONNECTING_DB_ERROR  );
        map.put("error", error);
        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    public static ResponseEntity<?> insertingInDB(String error){
        log.error(ErrorManage.INSERT_ERROR);
        Map<String, Object> map  = new HashMap<>();
        map.put("message", ErrorManage.INSERT_ERROR );
        map.put("error", error);
        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    public static ResponseEntity<?> updatingInDB(String error){
        log.error(ErrorManage.UPDATE_ERROR);
        Map<String, Object> map  = new HashMap<>();
        map.put("message", ErrorManage.UPDATE_ERROR );
        map.put("error", error);
        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    public static ResponseEntity<?> deletingInDB(String error){
        log.error(ErrorManage.DELETE_ERROR);
        Map<String, Object> map  = new HashMap<>();
        map.put("message", ErrorManage.DELETE_ERROR );
        map.put("error", error);
        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);

    }


}
