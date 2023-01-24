package com.fulfillment.fulfillmentmanager.repo;

import com.fulfillment.fulfillmentmanager.model.Name;

import java.util.List;

public interface NameRepository extends ReadOnlyRepository<Name, Integer> {
    List<Name> findByPersonName(String personName);
    public List<Name> findAll();

}