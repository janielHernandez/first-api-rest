package com.example.apirest.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String address;

    private String phone;

    @Column(name = "insert_date")
    @Temporal(TemporalType.DATE)
    private Date insertDate;




    public void update(Client c){
       this.address =  c.address;
       this.name =  c.name;
       this.email = c.email;
       this.phone = c.phone;
    }

    public Client(){

    }

    @PrePersist
    public void prePersist(){
        this.insertDate = new Date();
    }



}
