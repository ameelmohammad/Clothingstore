package com.example.clothstore.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clothstore.Entity.Customer;
import com.example.clothstore.Repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer saveOrUpdateCustomer(Customer customer) {

		if (customer.getFirstVisitDate() == null) { 
			customer.setFirstVisitDate(LocalDate.now());
		}
		customer.setLastVisitDate(LocalDate.now());

		return customerRepository.save(customer);
	}

	public Map<String, List<Customer>> getCustomersGroupedByType() {
		List<Customer> customers = customerRepository.findAll();
		return customers.stream().collect(Collectors.groupingBy(
				customer -> customer.getFirstVisitDate().isEqual(customer.getLastVisitDate()) ? "new" : "existing"));
	}

}
