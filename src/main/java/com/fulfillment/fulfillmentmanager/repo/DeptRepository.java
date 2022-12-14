package com.fulfillment.fulfillmentmanager.repo;

import com.fulfillment.fulfillmentmanager.model.Department;

import java.util.List;

public interface DeptRepository extends ReadOnlyRepository<Department, Integer> {
    List<Department> findByDeptName(String deptName);
}