package com.fulfillment.fulfillmentmanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    public Integer id;

    @Column(name = "item_name", nullable = false)
    public String itemName;

    //@Column(name = "dept_id", nullable = false)
    //public Integer deptId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    public Department department;

}
