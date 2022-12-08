package com.fulfillment.fulfillmentmanager.service;

import com.fulfillment.fulfillmentmanager.model.Department;
import com.fulfillment.fulfillmentmanager.exception.DepartmentNotFoundException;
import com.fulfillment.fulfillmentmanager.repo.DepartmentReadOnlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private final DepartmentReadOnlyRepository departmentRepo;

    @Autowired
    public DepartmentService(DepartmentReadOnlyRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public Department getDepartment(Integer id) {
        return departmentRepo.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Dept by id " + id + " was not found"));
    }
}
