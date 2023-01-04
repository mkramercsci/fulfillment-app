package com.fulfillment.fulfillmentmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BatchDetails {
    @Id
    public Integer dept_id;
    public Integer item_id;
    public Integer order_id;
    public Integer batch_id;
    public Integer quantity;
}
