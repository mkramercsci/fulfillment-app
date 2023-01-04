package com.fulfillment.fulfillmentmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    public Integer id;

    @Column(name = "customer_name", nullable = false)
    public String customerName;
}