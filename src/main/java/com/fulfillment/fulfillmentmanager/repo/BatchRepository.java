package com.fulfillment.fulfillmentmanager.repo;

import com.fulfillment.fulfillmentmanager.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepository extends JpaRepository <Batch, Integer> {

    void deleteById(Integer id);
}