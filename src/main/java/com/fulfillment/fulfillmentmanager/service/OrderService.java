package com.fulfillment.fulfillmentmanager.service;

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

    // add a new order with randomly generated name and id
    public Order addOrder () {

        Order order = new Order();

        // orderId should always be 8 digits
        order.setId(random.nextInt(99999999 - 10000000) + 10000000);

        // generate a random name and set it to the new order
        List<Name> names= nameRepository.findAll();
        Name randomName = names.get(random.nextInt(names.size() - 1));
        order.setName(randomName);

        return orderRepository.save(order);
    }
}
