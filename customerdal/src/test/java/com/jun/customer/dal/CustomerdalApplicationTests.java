package com.jun.customer.dal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jun.customer.dal.entities.Customer;
import com.jun.customer.dal.repos.CustomerRepository;

@SpringBootTest
class CustomerdalApplicationTests {

    @Autowired
    private CustomerRepository repo;

    @Test
    void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setName("Jun");
        ;
        customer.setEmail("kijoonh91@gmail.com");
        repo.save(customer);
    }

    @Test
    void testFindCustomerById() {
        Customer customer = repo.findById(1l).get();
        System.out.println(customer);
    }

    @Test
    void testUpdateCustomer() {
        Customer customer = repo.findById(1l).get();
        customer.setEmail("juki001@fh-dortmund.de");
        repo.save(customer);
    }

    @Test
    void testDeleteCustomer() {
        Customer customer = repo.findById(1l).get();
        repo.delete(customer);
    }

}
