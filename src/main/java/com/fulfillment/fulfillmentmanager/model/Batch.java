package com.fulfillment.fulfillmentmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "batches")
public class Batch {
    @Id
    public Integer id;
}
