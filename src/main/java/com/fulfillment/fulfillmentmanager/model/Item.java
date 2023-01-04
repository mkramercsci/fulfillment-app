package com.fulfillment.fulfillmentmanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    public Integer id;

    @Column(name = "dept_id", nullable = false)
    public Integer deptId;

    @Column(name = "item_name", nullable = false)
    public String itemName;
}
