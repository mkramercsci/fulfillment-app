package com.fulfillment.fulfillmentmanager.controller;

import com.fulfillment.fulfillmentmanager.model.Department;
import com.fulfillment.fulfillmentmanager.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // get a list of all departments
    // 0 - grocery
    // 1 - chemicals
    // 2 - clothes
    // 3 - accessories
    // 4 - seasonal
    // 5 - furniture
    // 6 - electronics
    // 7 - salesfloor
    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllDepartments () {
        List<Department> departments = deptService.findAll();

        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    // get one department based on its id
    @GetMapping("/{deptId}")
    public Department findById (@PathVariable("deptId") Integer id) {
        return deptService.findById(id);
    }
}
