package com.api.fleetmanagement.models;

import jakarta.persistence.*;
@Entity
@Table(name = "taxis")
public class TaxisModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String plate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;

    }


}

