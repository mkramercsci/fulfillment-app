package com.fulfillment.fulfillmentmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BatchDetails {
    @Id
    private Integer dept_id;
    private Integer item_id;
    private Integer order_id;
    private Integer batch_id;
    private Integer quantity;
}
