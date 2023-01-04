package com.fulfillment.fulfillmentmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Name {
    @Id
    public Integer id;

    @Column(name = "person_name", nullable = false)
    public String personName;
}
