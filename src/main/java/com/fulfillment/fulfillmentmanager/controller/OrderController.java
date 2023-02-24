package com.fulfillment.fulfillmentmanager.controller;

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

    // add a new order into the system
    @PostMapping("/add")
    public ResponseEntity<Order> addOrder() {

        Order newOrder = orderService.addOrder();
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    // get a list of all orders in the system
    @GetMapping("/all")
    public ResponseEntity<List<Order>> findAll () {

        List<Order> orders = orderService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}