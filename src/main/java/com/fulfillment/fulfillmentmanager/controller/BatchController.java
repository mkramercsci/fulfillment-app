package com.fulfillment.fulfillmentmanager.controller;

import com.fulfillment.fulfillmentmanager.model.Batch;
import com.fulfillment.fulfillmentmanager.service.BatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batches")
public class BatchController {

    private final BatchService batchService;

    public BatchController(BatchService batchService) {
        this.batchService = batchService;
    }

    // add a new batch to the list
    @PostMapping("/add")
    public ResponseEntity<Batch> addBatch() {
        Batch newBatch = new Batch();

        batchService.addBatch(newBatch);

        return new ResponseEntity<>(newBatch, HttpStatus.CREATED);
    }

    // this does not actually return all, it returns all batches where complete = false
    // to represent work that still needs to be done
    @GetMapping("/all")
    public ResponseEntity<List<Batch>> findAll () {
        List<Batch> batches = batchService.findAll();

        return new ResponseEntity<>(batches, HttpStatus.OK);
    }

    // get all completed batches (batches whose batch_details have all been picked)
    @GetMapping("/complete")
    public ResponseEntity<List<Batch>> findByComplete () {
        List<Batch> batches = batchService.findByComplete();

        return new ResponseEntity<>(batches, HttpStatus.OK);
    }

    // mark a whole batch as complete
    @PostMapping("/set_complete/{batchId}")
    public void setComplete(@PathVariable("batchId") Integer id) {
        batchService.setComplete(id);
    }

    // delete the batch and associated batch details
    @DeleteMapping("/delete/{batchId}")
    public ResponseEntity<?> deleteBatchById(@PathVariable("batchId") Integer id) {
        batchService.deleteBatch(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // delete EVERYTHING from repositories orders, batches, batch_details
    @DeleteMapping("/delete_all")
    public void deleteAll() {
        batchService.deleteAll();
    }
}
