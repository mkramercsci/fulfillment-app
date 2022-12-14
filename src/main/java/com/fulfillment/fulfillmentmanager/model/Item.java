package com.fulfillment.fulfillmentmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Item {
    @Id
    private Integer id;
    private Integer dept_id;

    @Column(name = "item_name", nullable = false)
    private String itemName;
}
