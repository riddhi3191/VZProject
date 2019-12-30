package com.riddhi.cloud.customerservice.Controller;


import com.riddhi.cloud.customerservice.Model.Customer;
import com.riddhi.cloud.customerservice.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/{email}")
    public Customer getCustomerByEmail(@PathVariable("email") String email) {
        Customer customerWithEmail = customerService.findByEmail(email);
        return customerWithEmail;
    }

    @GetMapping("/")
    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = customerService.findAllCustomers();
        return allCustomers;
    }


    @PostMapping("/add")
    public Customer addCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("failed to create customer...");
            return null;
        } else {
            System.out.println("Customer created..." + customer.getCreateAt());
            return customerService.addNewCustomer(customer);
        }
    }

}