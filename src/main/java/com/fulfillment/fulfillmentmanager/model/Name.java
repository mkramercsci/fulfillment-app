package com.fulfillment.fulfillmentmanager.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "names")
public class Name {
    @Id
    public Integer id;

    @Column(name="person_name")
    public String personName;

    @OneToMany(mappedBy = "name")
    public List<Order> orders;

    public Integer getId() {
        return id;
    }

    public String getPersonName() {
        return personName;
    }


}
