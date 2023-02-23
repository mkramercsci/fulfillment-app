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

    // get a list of all batches and their completion status
    // this returns all batches where complete = false
    @GetMapping("/all")
    public ResponseEntity<List<Batch>> findAll () {
        List<Batch> batches = batchService.findAll();

        return new ResponseEntity<>(batches, HttpStatus.OK);
    }

    @GetMapping("/complete")
    public ResponseEntity<List<Batch>> findByComplete () {
        List<Batch> batches = batchService.findByComplete();

        return new ResponseEntity<>(batches, HttpStatus.OK);
    }

    // add a new batch to the list
    @PostMapping("/add")
    public ResponseEntity<Batch> addBatch() {
        Batch newBatch = new Batch();

        batchService.addBatch(newBatch);

        return new ResponseEntity<>(newBatch, HttpStatus.CREATED);
    }

    @PostMapping("/set-complete/{batchId}")
    public void setComplete(@PathVariable("batchId") Integer id) {
        batchService.setComplete(id);
    }

    // delete the batch and associated batch details
    @DeleteMapping("/delete/{batchId}")
    public ResponseEntity<?> deleteBatchById(@PathVariable("batchId") Integer id) {
        batchService.deleteBatch(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // delete everything from repositories orders, batches, batch_details
    @DeleteMapping("/delete_all")
    public void deleteAll() {
        batchService.deleteAll();
    }
}
