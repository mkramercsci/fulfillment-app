package com.fulfillment.fulfillmentmanager.service;

import com.fulfillment.fulfillmentmanager.model.Batch;
import com.fulfillment.fulfillmentmanager.model.BatchDetailsId;
import com.fulfillment.fulfillmentmanager.model.Item;
import com.fulfillment.fulfillmentmanager.model.Order;
import com.fulfillment.fulfillmentmanager.repo.BatchDetailsRepository;
import com.fulfillment.fulfillmentmanager.repo.BatchRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BatchService {

    private final BatchRepository batchRepository;

    private final OrderService orderService;
    private final ItemService itemService;
    private final BatchDetailsService batchDetailsService;

    Random random = new Random();

    @Autowired
    public BatchService(BatchRepository batchRepository, OrderService orderService, ItemService itemService,
                        BatchDetailsService batchDetailsService,
                        BatchDetailsRepository batchDetailsRepository) {

        this.batchRepository = batchRepository;
        this.orderService = orderService;
        this.itemService = itemService;
        this.batchDetailsService = batchDetailsService;
    }

    // get all incomplete batches
    public List<Batch> findAll() {
        return batchRepository.findByComplete(false);
    }

    public List<Batch> findByComplete () { return batchRepository.findByComplete(true); }

    @Transactional
    public void deleteBatch (Integer id) {
        // the details should always get deleted before the batch itself
        batchDetailsService.deleteByBatchId(id);
        batchRepository.deleteById(id);
    }

    // delete EVERYTHING from batch_details, orders, and batches
    @Transactional
    public void deleteAll () {
        batchDetailsService.deleteAll();
        batchRepository.deleteAll();
        orderService.deleteAll();
    }

    // generate a new batch associated with 35 quantity of batch details
    public Batch addBatch (Batch batch) {

        // batch ids should always be 3 digits
        batch.setId(random.nextInt(999));
        batch.setComplete(false);
        batchRepository.save(batch);

        // keep a running total of eaches (quantity) within a batch
        Integer maxQuantity = 35;
        Integer totalQuantity = 0;
        Integer newQuantity = 0;

        //initialize the batch with an id, order and item
        BatchDetailsId newId;
        Order newOrder;
        Item newItem;

        // loop until the batch contains 35 quantity
        do {
            // get an order
            // 20% chance we use the order from the previous loop to simulate customers ordering multiple items
            if (createNewValue()) {
                newOrder = orderService.addOrder();
            }
            else { continue; }

            // get a random item
            newItem = itemService.getRandomItem();

            // how much free space is left in the batch?
            Integer rangeMax = maxQuantity - totalQuantity;

            // get a new quantity and update the batch total
            newQuantity = getNewQuantity(rangeMax);
            totalQuantity += newQuantity;

            //populate the id with valid integers
            newId = new BatchDetailsId(batch.getId(), newOrder.getId(), newItem.getDepartment().getId(), newItem.getId());

            // add a new record to the batch details repository
            batchDetailsService.add(newId, batch, newOrder, newItem, newQuantity);

        } while (totalQuantity < maxQuantity);

        return batch;
    }

    // helper function for addBatch
    // determine using 80/20 ratio whether to create a new value
    private Boolean createNewValue() {

        Integer randomValue = random.nextInt();

        // 80% make a new value
        if (randomValue < 8) {
            return true;
        }
        // 20% use the previously saved value
        else {
            return false;
        }
    }

    // helper function for addBatch
    // generate a new random quantity
    private Integer getNewQuantity (Integer rangeMax) {

        Integer newQuantity;
        Integer restrictedMax = 4;

        // we are on the final item, no calculation necessary
        if (rangeMax == 1) {
            return 1;
        }

        // never use a value larger than specified
        // this prevents whole batches being 35 quantity
        // or 2 large quantity items hogging the whole batch
        if (rangeMax > restrictedMax) {
            rangeMax = restrictedMax;
        }

        // generate and return a valid quantity
        newQuantity = random.nextInt(1, rangeMax);
        return newQuantity;
    }
}
