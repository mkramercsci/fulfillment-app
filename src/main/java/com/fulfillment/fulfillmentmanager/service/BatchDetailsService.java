package com.fulfillment.fulfillmentmanager.service;

import com.fulfillment.fulfillmentmanager.model.Batch;
import com.fulfillment.fulfillmentmanager.model.BatchDetails;
import com.fulfillment.fulfillmentmanager.model.Item;
import com.fulfillment.fulfillmentmanager.model.Order;
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
    public BatchDetails add(Batch batch, Order order, Item item, Integer quantity) {
        BatchDetails batchDetails = new BatchDetails();

        batchDetails.id.setBatch(batch);
        batchDetails.id.setOrder(order);
        batchDetails.id.setDepartment(item.department);
        batchDetails.id.setItem(item);
        batchDetails.setQuantity(quantity);
        batchDetails.setPicked(false);

        return batchDetailsRepository.save(batchDetails);
    }

    public void deleteByBatchId(Integer id) {
        batchDetailsRepository.deleteByBatchId(id);
    }
}
