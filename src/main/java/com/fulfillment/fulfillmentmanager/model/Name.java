package com.fulfillment.fulfillmentmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Name {
    @Id
    private Integer id;

    @Column(name = "person_name", nullable = false)
    private String personName;
}
