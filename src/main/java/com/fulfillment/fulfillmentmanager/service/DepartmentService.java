package com.fulfillment.fulfillmentmanager.service;

import com.fulfillment.fulfillmentmanager.model.Department;
import com.fulfillment.fulfillmentmanager.exception.GenericNotFoundException;
import com.fulfillment.fulfillmentmanager.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepo) {
        this.departmentRepository = departmentRepo;
    }

    public Department getDepartment(Integer id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException("Dept by id " + id + " was not found"));
    }

    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }
}
