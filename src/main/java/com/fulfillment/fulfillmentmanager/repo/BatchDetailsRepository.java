package com.fulfillment.fulfillmentmanager.repo;

import com.fulfillment.fulfillmentmanager.model.BatchDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchDetailsRepository extends JpaRepository<BatchDetails, Integer> {

    List<BatchDetails> findByBatchId(Integer batchId);
}
