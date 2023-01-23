package com.fulfillment.fulfillmentmanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    public Integer id;

    @Column(name = "item_name", nullable = false)
    public String itemName;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    public Department department;
}
