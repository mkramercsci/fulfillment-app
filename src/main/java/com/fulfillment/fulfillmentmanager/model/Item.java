package com.fulfillment.fulfillmentmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "items")
public class Item {

    // mapping all database columns to Entity values

    @Id
    public Integer id;

    @Column(name = "item_name", nullable = false)
    public String itemName;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    public Department department;

    @OneToMany
    @JsonIgnore
    private List<BatchDetails> batchDetailsList;
}
