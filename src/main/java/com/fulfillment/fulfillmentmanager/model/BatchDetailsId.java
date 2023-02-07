package com.fulfillment.fulfillmentmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

// code referenced from here
// https://attacomsian.com/blog/spring-data-jpa-composite-primary-key

// provides the compound key batch + order + item to the class BatchDetails

@Embeddable
public class BatchDetailsId implements Serializable {

    private Integer batchId;

    private Integer orderId;

    private Integer deptId;

    private Integer itemId;

    public BatchDetailsId() {}

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    // getters and setters

    public Integer getBatch() {
        return batchId;
    }

    public void setBatch(Batch batch) {
        this.batchId = batch.getId();
    }

    public Integer getOrder() {
        return orderId;
    }

    public void setOrder(Order order) {
        this.orderId = order.getId();
    }

    public Integer getDepartment() {
        return deptId;
    }

    public void setDepartment(Department department) {
        this.deptId = department.getId();
    }

    public Integer getItem() {
        return itemId;
    }

    public void setItem(Item item) {
        this.itemId = item.getId();
    }

}
