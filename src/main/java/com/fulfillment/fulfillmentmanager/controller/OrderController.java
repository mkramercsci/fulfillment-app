package com.fulfillment.fulfillmentmanager.controller;

import com.fulfillment.fulfillmentmanager.model.Batch;
import com.fulfillment.fulfillmentmanager.model.Order;
import com.fulfillment.fulfillmentmanager.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController (OrderService orderService) { this.orderService = orderService;}

    // get a list of all orders in the system
    @GetMapping("/all")
    public ResponseEntity<List<Order>> findAll () {

        List<Order> orders = orderService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // add a new order into the system
    @PostMapping("/add")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {

        Order newOrder = orderService.addOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

}