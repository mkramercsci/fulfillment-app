package com.fulfillment.fulfillmentmanager.controller;

import com.fulfillment.fulfillmentmanager.model.Department;
import com.fulfillment.fulfillmentmanager.model.Item;
import com.fulfillment.fulfillmentmanager.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/all")
    public List<Item> findAllItems () {
        return itemService.findAllItems();
    }

    @GetMapping("/{deptId}")
    public List<Item> getItemsByDeptId (@PathVariable ("deptId") Integer id) {
        return itemService.getByDeptId(id);
    }

    @GetMapping("/random")
    public Item getRandomItem () {
        return itemService.getRandomItem();
    }
}