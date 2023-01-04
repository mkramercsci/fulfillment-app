package com.fulfillment.fulfillmentmanager.repo;

import com.fulfillment.fulfillmentmanager.model.Item;

import java.util.List;

public interface ItemRepository extends ReadOnlyRepository<Item, Integer> {
    List<Item> findByItemName(String itemName);
    List<Item> findByDeptId(Integer deptId);
}