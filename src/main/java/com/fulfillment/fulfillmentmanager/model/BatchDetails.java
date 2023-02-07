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

    public BatchDetails() {
        this.id = new BatchDetailsId();

        this.batch = new Batch();
        this.order = new Order();
        this.department = new Department();
        this.item = new Item();

        this.picked = false;
        this.quantity = 0;
    }

    public BatchDetails(BatchDetailsId id, Batch batch, Order order, Department department, Item item, Integer quantity) {
        this.id = id;
        this.id.setBatch(batch);
        this.id.setOrder(order);
        this.id.setDepartment(department);
        this.id.setItem(item);

        this.setPicked(false);
        this.setQuantity(quantity);
    }

    // getters and setters

    public BatchDetailsId getId() {
        return id;
    }

    public void setId(BatchDetailsId id) {
        this.id = id;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

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

    @Override
    public String toString() {
        return "BatchDetails{" +
                "id=" + id +
                ", batch=" + batch +
                ", order=" + order +
                ", department=" + department +
                ", item=" + item +
                ", picked=" + picked +
                ", quantity=" + quantity +
                '}';
    }
}
