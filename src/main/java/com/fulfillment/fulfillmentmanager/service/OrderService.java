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

    // add a new order with randomly generated name and id
    public Order addOrder (Order order) {

        // order Id should always be 8 digits 1000000-99999999
        order.setId(random.nextInt(99999999));

        //List<Name> names = nameRepository.findAll();

        //Name randomName = names.get(random.nextInt(names.size() - 1));

        order.setCustomerName(nameRepository.findAll().get(0));

        return orderRepository.save(order);
    }

    public String testing() {
        Name name = nameRepository.findAll().get(0);
        String s = name.getPersonName();
        return s;
    }

}
