package com.fulfillment.fulfillmentmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "batches")
public class Batch {

    // mapping all database columns to Entity values

    @Id
    private Integer id;

    @JsonIgnore
    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BatchDetails> batchDetailsList;

    @Column(name="complete", nullable = false, columnDefinition = "boolean default false")
    private Boolean complete;

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // aka getComplete
    public Boolean isComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

}
