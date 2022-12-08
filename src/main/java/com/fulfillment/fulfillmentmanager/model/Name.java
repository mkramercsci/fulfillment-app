package com.fulfillment.fulfillmentmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Name {
    @Id
    private Integer id;
    private String person_name;
}
