package com.fulfillment.fulfillmentmanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "batch_details")
public class BatchDetails {

    @EmbeddedId
    public BatchDetailsId id;

    @MapsId("batchId")
    @ManyToOne
    private Batch batch;

    @MapsId("orderId")
    @ManyToOne
    private Order order;

    @MapsId("deptId")
    @ManyToOne
    @JoinColumn(name="dept_id") // match database column name
    private Department department;

    @MapsId("itemId")
    @ManyToOne
    private Item item;

    @Column(name="picked", nullable = false, columnDefinition = "boolean default false")
    private Boolean picked;

    @Column(nullable = false)
    private Integer quantity;

    // constructors

    public BatchDetails() {}

    public BatchDetails(BatchDetailsId id, Batch batch, Order order, Department department, Item item, Boolean picked, Integer quantity) {
        this.id = id;
        this.batch = batch;
        this.order = order;
        this.department = department;
        this.item = item;
        this.picked = picked;
        this.quantity = quantity;
    }

    // getters and setters

    public Boolean isPicked() {
        return picked;
    }

    public void setPicked(Boolean picked) {
        this.picked = picked;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
