package com.fulfillment.fulfillmentmanager.service;

import com.fulfillment.fulfillmentmanager.model.Department;
import com.fulfillment.fulfillmentmanager.exception.DepartmentNotFoundException;
import com.fulfillment.fulfillmentmanager.repo.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    private final DeptRepository departmentRepo;

    @Autowired
    public DeptService(DeptRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public Department getDepartment(Integer id) {
        return departmentRepo.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Dept by id " + id + " was not found"));
    }

    public List<Department> findAllDepts() {
        return departmentRepo.findAll();
    }
}
