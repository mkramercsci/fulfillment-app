package com.fulfillment.fulfillmentmanager.controller;

import com.fulfillment.fulfillmentmanager.model.Batch;
import com.fulfillment.fulfillmentmanager.model.Department;
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

    @GetMapping("/all")
    public ResponseEntity<List<Batch>> findAll () {
        List<Batch> batches = batchService.findAll();

        return new ResponseEntity<>(batches, HttpStatus.OK);
    }

    // http request should send an empty JSON object, the Id is randomly generated in BatchService
    @PostMapping("/add")
    public ResponseEntity<Batch> addBatch(@RequestBody Batch batch) {
        Batch newBatch = batchService.addBatch(batch);
        return new ResponseEntity<>(newBatch, HttpStatus.CREATED);
    }
}
