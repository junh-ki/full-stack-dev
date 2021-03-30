package com.jun.flightreservation.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass // this class is not directly mapped to the data table, instead it acts as a parent class for all the other entities
public class AbstractEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) // this annotation says that this id field will be automatically incremented in the database for us
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
