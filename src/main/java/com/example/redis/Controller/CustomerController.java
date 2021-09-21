package com.example.redis.Controller;

import com.example.redis.Model.Customer;
import com.example.redis.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Customer> getAllCustomer()
    {
        System.out.println("Values Displayed");
        return (List<Customer>) customerService.getAllCustomer();
    }

    @GetMapping("/get/{id}")
    public Customer getCustomerById(@PathVariable(value = "id")int id)
    {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable(value = "id")int id)
    {
          customerService.deleteCustomer(id);
    }

    @PutMapping("/put/{id}")
    public Customer update(@RequestBody Customer customer,@PathVariable(value = "id") int id)
    {
        customerService.update(id,customer);
        return customer;
    }
}
