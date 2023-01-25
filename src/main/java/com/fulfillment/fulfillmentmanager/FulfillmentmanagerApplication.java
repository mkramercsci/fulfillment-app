package com.fulfillment.fulfillmentmanager;

import com.fulfillment.fulfillmentmanager.model.Batch;
import com.fulfillment.fulfillmentmanager.model.BatchDetails;
import com.fulfillment.fulfillmentmanager.model.Department;
import com.fulfillment.fulfillmentmanager.model.Item;
import com.fulfillment.fulfillmentmanager.repo.DepartmentRepository;
import com.fulfillment.fulfillmentmanager.repo.ItemRepository;
import com.fulfillment.fulfillmentmanager.service.ItemService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

// NAMING CONVENTIONS
// database columns are underscored (dept_id)
// class objects are camelCase (deptId)

// ORDER OF PARAMETERS & ids
// batch id > order id > dept id > item id
//

@SpringBootApplication
public class FulfillmentmanagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(FulfillmentmanagerApplication.class, args);

	}

}
