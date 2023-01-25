package com.fulfillment.fulfillmentmanager.model;

import java.io.Serializable;

// code referenced from here
// https://attacomsian.com/blog/spring-data-jpa-composite-primary-key

// provides the compound key batch + order + item to the class BatchDetails

public class BatchDetailsId implements Serializable {
    private Batch batch;
    private Order order;
    private Item item;

    public BatchDetailsId() {}

    public BatchDetailsId(Batch batch, Order order, Department dept, Item item) {
        this.batch = batch;
        this.order = order;
        this.item = item;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
