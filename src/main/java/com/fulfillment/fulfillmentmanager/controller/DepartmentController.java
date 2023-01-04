package com.fulfillment.fulfillmentmanager.controller;

import com.fulfillment.fulfillmentmanager.model.Department;
import com.fulfillment.fulfillmentmanager.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService deptService;

    public DepartmentController(DepartmentService deptService) {
        this.deptService = deptService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllDepartments () {
        List<Department> departments = deptService.findAllDepartments();

        return new ResponseEntity<>(departments, HttpStatus.OK);
    }
}
