package com.fulfillment.fulfillmentmanager.service;

import com.fulfillment.fulfillmentmanager.model.*;
import com.fulfillment.fulfillmentmanager.repo.BatchDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchDetailsService {
    private final BatchDetailsRepository batchDetailsRepository;

    @Autowired
    public BatchDetailsService(BatchDetailsRepository batchDetailsRepository) {
        this.batchDetailsRepository = batchDetailsRepository;
    }

    public List<BatchDetails> findAll() {
        return batchDetailsRepository.findAll();
    }

    public List<BatchDetails> findByBatchId(Integer batchId) {
        return batchDetailsRepository.findByBatchId(batchId);
    }

    // insert a new record with valid data into the database
    public BatchDetails add(BatchDetailsId batchDetailsId,
                            Batch batch, Order order, Item item, Integer quantity) {

        // set up the id for the new record
        BatchDetails batchDetails = new BatchDetails();
        batchDetails.setId(batchDetailsId);

        // set the composite key values
        batchDetails.setBatch(batch);
        batchDetails.setOrder(order);
        batchDetails.setDepartment(item.department);
        batchDetails.setItem(item);

        // set the extra data
        batchDetails.setQuantity(quantity);
        batchDetails.setPicked(false);

        // add a new record to the batch details repository
        return batchDetailsRepository.save(batchDetails);
    }

    public void deleteByBatchId(Integer id) {
        batchDetailsRepository.deleteByBatchId(id);
    }

    public void deleteAll() {
        batchDetailsRepository.deleteAll();
    }

}
