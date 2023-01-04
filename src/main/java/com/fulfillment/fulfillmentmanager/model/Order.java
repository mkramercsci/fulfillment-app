package com.fulfillment.fulfillmentmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Order {
    @Id
    public Integer id;
    public String customer_name;
}