package com.fulfillment.fulfillmentmanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "batch_details")
@IdClass(BatchDetailsId.class)
public class BatchDetails {

    // mapping all database columns to Entity values

    @Id
    @ManyToOne
    @JoinColumn(name = "batch_id")
    public Batch batch;

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    public Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    public Item item;

    @Column(name="complete", nullable = false, columnDefinition = "boolean default false")
    private Boolean complete;

    @Column(nullable = false)
    public Integer quantity;
}
