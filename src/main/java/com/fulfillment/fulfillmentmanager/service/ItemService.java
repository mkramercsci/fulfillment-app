package com.fulfillment.fulfillmentmanager.service;

import com.fulfillment.fulfillmentmanager.model.Item;
import com.fulfillment.fulfillmentmanager.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepo) {
        this.itemRepository = itemRepo;
    }

    //public List<Item> findByDeptId(Integer id) {
        //return itemRepository.findByDeptId(id);
    //}

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    // return one randomly selected item from the list of 128 items
    public Item getRandomItem() {
        Random random = new Random();

        Integer max = findAll().size();

        return findAll().get(random.nextInt(max));

    }

    public String testing () {

        return Integer.toString(findAll().size());
    }

}