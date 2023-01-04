package com.fulfillment.fulfillmentmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "batch_details")
public class BatchDetails {
    @Id
    @Column(name = "dept_id", nullable = false)
    public Integer deptId;

    @Column(name = "item_id", nullable = false)
    public Integer itemId;

    @Column(name = "order_id", nullable = false)
    public Integer orderId;

    @Column(name = "batch_id", nullable = false)
    public Integer batchId;

    @Column(name = "", nullable = false)
    public Integer quantity;
}
