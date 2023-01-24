package com.fulfillment.fulfillmentmanager.service;

import com.fulfillment.fulfillmentmanager.model.Batch;
import com.fulfillment.fulfillmentmanager.repo.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BatchService {

    private final BatchRepository batchRepository;

    @Autowired
    public BatchService(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    Random random = new Random();

    public List<Batch> findAll() {
        return batchRepository.findAll();
    }

    public Batch addBatch (Batch batch) {

        // batch ids should always be 3 digits
        batch.setId(random.nextInt(999));

        batch.setComplete(false);

        // LOGIC FOR A NEW GENERATED BATCH GOES HERE

        //loop begins

        // get a new order id OR create one (% chance to do either)

        // get a random item

        // check the current quantity. is it > 1 ?
            // if no, quantity = 1. exit the loop
            // if yes, generate random value 1-10.
                // if new quantity + current quantity < max quantity, fantastic
                // else set new quantity = max quantity - current quantity

        // we now have valid batch id, order id, item id, quantity and this is a new
        // record so the batchDetails complete = false

        // insert the record into batch details

        //continue loop until current quantity = max quantity (35)

        return batchRepository.save(batch);
    }

}
