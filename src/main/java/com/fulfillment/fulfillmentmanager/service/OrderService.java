package com.fulfillment.fulfillmentmanager.service;

import com.fulfillment.fulfillmentmanager.model.Batch;
import com.fulfillment.fulfillmentmanager.model.Name;
import com.fulfillment.fulfillmentmanager.model.Order;
import com.fulfillment.fulfillmentmanager.repo.NameRepository;
import com.fulfillment.fulfillmentmanager.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final NameRepository nameRepository;
    Random random = new Random();

    @Autowired
    public OrderService(OrderRepository orderRepository, NameRepository nameRepository) {
        this.orderRepository = orderRepository;
        this.nameRepository = nameRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order addOrder (Order order) {

        // order Id should always be 8 digits
        order.setId(random.nextInt(99999999));

        // select a random customer name from the database
        // this application is from the fulfillment employee's perspective,
        // so customer names come from outside the store and are not input from the employee
        List<Name> names = nameRepository.findAll();
        order.setCustomerName(names.get(random.nextInt(names.size() - 1)).personName);

        return orderRepository.save(order);
    }

}
