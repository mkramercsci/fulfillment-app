package com.fulfillment.fulfillmentmanager;

import com.fulfillment.fulfillmentmanager.model.Department;
import com.fulfillment.fulfillmentmanager.repo.DepartmentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

// NAMING CONVENTIONS
// database columns are underscored (dept_id)
// class objects are camelCase (deptId)

@SpringBootApplication
public class FulfillmentmanagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(FulfillmentmanagerApplication.class, args);

	}

}
