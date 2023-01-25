package com.fulfillment.fulfillmentmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    // mapping all database columns to Entity values

    @Id
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "name_id")
    public Name name;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<BatchDetails> batchDetailsList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}