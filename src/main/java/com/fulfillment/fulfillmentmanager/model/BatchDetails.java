package com.fulfillment.fulfillmentmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BatchDetails {
    @Id
    public Integer deptId;
    public Integer itemId;
    public Integer orderId;
    public Integer batchId;
    public Integer quantity;
}
