package com.riddhi.cloud.customerservice.Service;


import com.riddhi.cloud.customerservice.Model.Customer;
import com.riddhi.cloud.customerservice.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer findByEmail(String email) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
        if (optionalCustomer.isPresent()) {
            System.out.println("customer with email " + email + " found!!!");
            return optionalCustomer.get();
        } else {
            System.out.println("customer with email " + email + " NOT FOUND!!!");
            return null;
        }
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer addNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

}
