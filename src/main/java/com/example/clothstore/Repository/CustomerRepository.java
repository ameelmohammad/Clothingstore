package com.example.clothstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clothstore.Entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
