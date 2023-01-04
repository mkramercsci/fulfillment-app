package com.fulfillment.fulfillmentmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "names")
public class Name {
    @Id
    public Integer id;

    @Column(name = "person_name", nullable = false)
    public String personName;
}
