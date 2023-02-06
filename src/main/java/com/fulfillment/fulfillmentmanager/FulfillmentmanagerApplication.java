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
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
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

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
