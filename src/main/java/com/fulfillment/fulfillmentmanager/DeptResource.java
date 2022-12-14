package com.fulfillment.fulfillmentmanager;

import com.fulfillment.fulfillmentmanager.model.Department;
import com.fulfillment.fulfillmentmanager.service.DeptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DeptResource {
    private final DeptService deptService;

    public DeptResource(DeptService deptService) {
        this.deptService = deptService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllDepartments () {
        List<Department> departments = deptService.findAllDepts();

        return new ResponseEntity<>(departments, HttpStatus.OK);

    }
}
