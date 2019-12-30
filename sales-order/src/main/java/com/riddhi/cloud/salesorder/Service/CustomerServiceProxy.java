package com.riddhi.cloud.salesorder.Service;


import com.riddhi.cloud.salesorder.Model.Customer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name="customer-service")       // you do not need the url while using the Ribbon load balancing
//@FeignClient(name="zuul-api-gateway-server")    // to make requests go through the ZUUL API GATEWAY
@RibbonClient(name = "customer-service")
public interface CustomerServiceProxy  {

    default void show()
    {
        System.out.println("Default Method Executed");
    }

    @GetMapping("/api/customers/{email}")
//    @GetMapping("/customer-service/api/customers/{email}")
    public Customer getCustomerByEmail(@PathVariable("email") String email);

    @GetMapping("/api/customers")
//    @GetMapping("/customer-service/api/customers")
    public List<Customer> getAllCustomers();

}
