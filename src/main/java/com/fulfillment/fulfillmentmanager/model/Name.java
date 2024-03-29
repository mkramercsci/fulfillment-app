package com.fulfillment.fulfillmentmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "names")
public class Name {

    // mapping all database columns to Entity values

    @Id
    private Integer id;

    @Column(name="person_name")
    public String personName;

    @JsonIgnore
    @OneToMany(mappedBy = "name")
    public List<Order> orders;

    public Integer getId() {
        return id;
    }

    public String getPersonName() {
        return personName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "id=" + id +
                ", personName='" + personName + '\'' +
                '}';
    }
}
