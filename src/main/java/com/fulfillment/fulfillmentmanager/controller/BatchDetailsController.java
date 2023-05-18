package com.fulfillment.fulfillmentmanager.controller;

import com.fulfillment.fulfillmentmanager.model.BatchDetails;
import com.fulfillment.fulfillmentmanager.service.BatchDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // get the 35 items that belong to a particular batch
    @GetMapping("/{batchId}")
    public ResponseEntity<List<BatchDetails>> findByBatchId (@PathVariable("batchId") Integer batchId) {
        List<BatchDetails> batchDetails = batchDetailsService.findByBatchId(batchId);

        return new ResponseEntity<>(batchDetails, HttpStatus.OK);
    }

    // send the parameters to the service layer to set the right details complete
    @PostMapping("/set_complete/{batchId}/{orderId}/{deptId}/{itemId}")
    public void setDetailsComplete (
            @PathVariable("batchId") Integer batchId,
            @PathVariable("orderId") Integer orderId,
            @PathVariable("deptId") Integer deptId,
            @PathVariable("itemId") Integer itemId) {

        batchDetailsService.setDetailsComplete(batchId, orderId, deptId, itemId);

    }

}
