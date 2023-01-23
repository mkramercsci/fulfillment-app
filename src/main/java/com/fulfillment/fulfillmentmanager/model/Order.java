package com.fulfillment.fulfillmentmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "name_id")
    private Name name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Name getCustomerName() {
        return name;
    }

    public void setCustomerName(Name customerName) {
        this.name = customerName;
    }
}