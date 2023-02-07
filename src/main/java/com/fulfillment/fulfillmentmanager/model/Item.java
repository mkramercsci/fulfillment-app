package com.fulfillment.fulfillmentmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "items")
public class Item {

    // mapping all database columns to Entity values

    @Id
    private Integer id;

    @Column(name = "item_name", nullable = false)
    public String itemName;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    public Department department;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
