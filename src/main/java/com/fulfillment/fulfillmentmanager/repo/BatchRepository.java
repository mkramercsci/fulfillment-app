package com.fulfillment.fulfillmentmanager.repo;

import com.fulfillment.fulfillmentmanager.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchRepository extends JpaRepository <Batch, Integer> {

    List<Batch> findByComplete(Boolean complete);

    void deleteById(Integer id);

    void deleteAll();
}