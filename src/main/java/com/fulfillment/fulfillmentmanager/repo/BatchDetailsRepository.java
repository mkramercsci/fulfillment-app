package com.fulfillment.fulfillmentmanager.repo;

import com.fulfillment.fulfillmentmanager.model.BatchDetails;
import com.fulfillment.fulfillmentmanager.model.BatchDetailsId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchDetailsRepository extends JpaRepository<BatchDetails, BatchDetailsId> {

    void deleteByBatchId(Integer id);

    void deleteAll();

    List<BatchDetails> findAllByBatchIdOrderByDepartmentAsc(Integer batchId);

}
