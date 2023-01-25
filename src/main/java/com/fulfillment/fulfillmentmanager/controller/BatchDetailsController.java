package com.fulfillment.fulfillmentmanager.controller;

import com.fulfillment.fulfillmentmanager.model.BatchDetails;
import com.fulfillment.fulfillmentmanager.service.BatchDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/batch_details")
public class BatchDetailsController {
    private final BatchDetailsService batchDetailsService;

    public BatchDetailsController(BatchDetailsService batchDetailsService) {
        this.batchDetailsService = batchDetailsService;
    }

    // get a list of all batch_details records
    @GetMapping("/all")
    public ResponseEntity<List<BatchDetails>> findAll () {
        List<BatchDetails> batchDetails = batchDetailsService.findAll();

        return new ResponseEntity<>(batchDetails, HttpStatus.OK);
    }

}
