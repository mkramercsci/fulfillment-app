package com.fulfillment.fulfillmentmanager.service;

import com.fulfillment.fulfillmentmanager.model.Department;
import com.fulfillment.fulfillmentmanager.exception.GenericNotFoundException;
import com.fulfillment.fulfillmentmanager.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

//      0 | grocery
//      1 | chemicals
//      2 | clothes
//      3 | accessories
//      4 | seasonal
//      5 | furniture
//      6 | electronics
//      7 | salesfloor

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepo) {
        this.departmentRepository = departmentRepo;
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department findById(Integer id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException("Dept by id " + id + " was not found"));
    }
}