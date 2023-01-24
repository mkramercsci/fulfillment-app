package com.fulfillment.fulfillmentmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "names")
public class Name {

    // mapping all database columns to Entity values

    @Id
    public Integer id;

    @Column(name="person_name")
    public String personName;

    @OneToMany(mappedBy = "name")
    @JsonIgnore
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
