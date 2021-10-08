package com.example.redis.Controller;

import com.example.redis.Model.Customer;
import com.example.redis.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/post")
    public Customer saveCustomer(@RequestBody Customer customer)
    {
       return customerService.saveCustomer(customer);
    }

    @GetMapping("/get")
    public Map<Long,Customer> getAllCustomer()
    {
        System.out.println("Values Displayed");
        return customerService.getAllCustomer();
    }

    @GetMapping("/get/{id}")
    public Customer getCustomerById(@PathVariable(value = "id")long id)
    {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable(value = "id")long id)
    {
          customerService.deleteCustomer(id);
    }

    @PutMapping("/put/{id}")
    public Customer updateCustomer(@PathVariable(value = "id") long id,@RequestBody Customer customer)
    {
        return customerService.updateCustomer(id,customer);

    }
}
