package com.fulfillment.fulfillmentmanager.repo;

import com.fulfillment.fulfillmentmanager.model.Department;

import java.util.List;

public interface DepartmentReadOnlyRepository extends ReadOnlyRepository<Department, Integer> {
    List<Department> findByName(String name);
}
