package com.fulfillment.fulfillmentmanager.service;

import com.fulfillment.fulfillmentmanager.model.Batch;
import com.fulfillment.fulfillmentmanager.model.BatchDetails;
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

}
