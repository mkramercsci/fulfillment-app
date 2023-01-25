package com.fulfillment.fulfillmentmanager.service;

import com.fulfillment.fulfillmentmanager.model.Batch;
import com.fulfillment.fulfillmentmanager.model.Item;
import com.fulfillment.fulfillmentmanager.model.Order;
import com.fulfillment.fulfillmentmanager.repo.BatchRepository;
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
                        BatchDetailsService batchDetailsService) {

        this.batchRepository = batchRepository;
        this.orderService = orderService;
        this.itemService = itemService;
        this.batchDetailsService = batchDetailsService;
    }

    // get all existing batches
    public List<Batch> findAll() {
        return batchRepository.findAll();
    }

    public Batch addBatch (Batch batch) {

        // batch ids should always be 3 digits
        batch.setId(random.nextInt(999));
        batch.setComplete(false);
        batchRepository.save(batch);

        // keep a running total of eaches (quantity) within a batch
        Integer maxQuantity = 35;
        Integer totalQuantity = 0;
        Integer newQuantity = 0;

        //initialize the batch with an order and item
        Order order;
        Item item;

        // loop until the batch contains 35 quantity
        do {
            // get an order
            // 20% chance we use the order from the previous loop
            if (createNewValue()) {
                order = orderService.addOrder();
            }
            else { continue; }

            // get a random item
            item = itemService.getRandomItem();

            // how much free space is left in the batch?
            Integer rangeMax = maxQuantity - totalQuantity;

            // get a new quantity and update the batch total
            newQuantity = getNewQuantity(maxQuantity, totalQuantity, rangeMax);
            totalQuantity += newQuantity;

            // add a new record to the batch details repository
            batchDetailsService.add(batch, order, item, newQuantity);

        } while (totalQuantity < maxQuantity);

        return batch;
    }

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

    // generate a new random quantity
    private Integer getNewQuantity (Integer maxQuantity, Integer totalQuantity, Integer rangeMax) {

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

    // method for testing
    public void testing () {
    /*        Integer maxQuantity = 35;
        Integer totalQuantity = 0;
        Integer newQuantity = 0;

        do {
            // how much free space is left?
            Integer rangeMax = maxQuantity - totalQuantity;

            // this program should never return a value larger than 8
            if (rangeMax > 8) {
                rangeMax = 8;
            }
            else if (rangeMax == 1) {
                newQuantity = 1;
                break;
            }

            String printMe = rangeMax + " | "+ newQuantity + " | " + totalQuantity;
            System.out.println(printMe);

            do {
                newQuantity = random.nextInt(1, rangeMax);

            } while (totalQuantity + newQuantity > maxQuantity);

            totalQuantity += newQuantity;

        } while (totalQuantity < maxQuantity);

        totalQuantity += newQuantity;

        String done = "Finished with total quantity: " + totalQuantity;
        System.out.println(done);

    */
    }
}
