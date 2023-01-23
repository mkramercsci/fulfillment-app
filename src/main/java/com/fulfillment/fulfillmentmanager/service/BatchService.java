package com.fulfillment.fulfillmentmanager.service;

import com.fulfillment.fulfillmentmanager.model.Batch;
import com.fulfillment.fulfillmentmanager.repo.BatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BatchService {

    private final BatchRepository batchRepository;

    Random random = new Random();

    public BatchService(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    public List<Batch> findAll() {
        return batchRepository.findAll();
    }

    public Batch addBatch (Batch batch) {

        // batch ids should always be 3 digits
        batch.setId(random.nextInt(999));

        return batchRepository.save(batch);
    }

}
