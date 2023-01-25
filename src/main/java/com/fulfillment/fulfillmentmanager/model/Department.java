package com.fulfillment.fulfillmentmanager.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    // mapping all database columns to Entity values

    @Id
    private Integer id;

    @Column(name = "dept_name", nullable = false)
    private String deptName;

    @OneToMany(mappedBy = "department")
    private List<Item> items;

    @OneToMany(mappedBy = "department")
    private List<BatchDetails> batchDetailsList;
    // getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + deptName + '\'' +
                '}';
    }

}
