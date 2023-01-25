package com.fulfillment.fulfillmentmanager.controller;

import com.fulfillment.fulfillmentmanager.model.Item;
import com.fulfillment.fulfillmentmanager.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // get a list of 128 total items
    // 16 items * 8 departments = 128 total items
    @GetMapping("/all")
    public List<Item> getAllItems () {
        return itemService.findAll();
    }

    // get a single random item
    @GetMapping("/random")
    public Item getRandomItem () {
        return itemService.getRandomItem();
    }

}