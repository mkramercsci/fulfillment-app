package com.fulfillment.fulfillmentmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// NAMING CONVENTIONS
// database columns are underscored (dept_id)
// class objects are camelCase (deptId)

@SpringBootApplication
public class FulfillmentmanagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(FulfillmentmanagerApplication.class, args);
	}

}
