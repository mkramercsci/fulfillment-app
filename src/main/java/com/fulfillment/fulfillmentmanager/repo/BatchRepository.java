package com.fulfillment.fulfillmentmanager.repo;

import com.fulfillment.fulfillmentmanager.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BatchRepository extends JpaRepository <Batch, Integer> {
    @Transactional
    @Modifying
    @Query("update Batch b set b.complete = true where b.id = :id")
    Integer updateComplete(@Param("id") Integer id);

    List<Batch> findByComplete(Boolean complete);

    void deleteById(Integer id);

    void deleteAll();
}