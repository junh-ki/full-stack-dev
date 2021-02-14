package com.jun.customer.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.jun.customer.dal.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
