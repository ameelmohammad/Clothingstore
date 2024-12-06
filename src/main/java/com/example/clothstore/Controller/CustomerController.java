package com.example.clothstore.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clothstore.Entity.Customer;
import com.example.clothstore.Service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/save")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveOrUpdateCustomer(customer);
	}

	@GetMapping("/type-report")
	public Map<String, List<Customer>> getCustomersByType() {
		return customerService.getCustomersGroupedByType();
	}

	@GetMapping("/all")
	public List<Customer> getAllCustomers() {
		return customerService.getCustomersGroupedByType().values().stream().flatMap(List::stream).toList();
	}

}
