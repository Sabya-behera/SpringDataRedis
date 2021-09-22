package com.example.redis.Service;

import com.example.redis.Model.Customer;
import com.example.redis.Repositiory.CustomerRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.Map;

/*------------------------------------REDIS As a Cache-----------------------------------*/
@Service
@EnableCaching                                        //To implement Caching mechanism
public class CustomerService {

    @Autowired
    CustomerRepoImpl customerRepo;

    public Customer saveCustomer(Customer customer) {
        return customerRepo.saveCustomer(customer);

    }

    public Map<Long,Customer> getAllCustomer() {
        return  customerRepo.findAll();
    }

    @Cacheable(key = "#id",value = "Customer")               //key-value pair  can write conditions also for a method
    public Customer getCustomerById(long id) {
        Customer customer=customerRepo.findById(id);
        return customer;
    }

    @CacheEvict(key = "#id",value = "Customer")                                       // delete as well from the cache memory as long from database
    public void deleteCustomer(long id) {
      customerRepo.deleteById(id);
    }

    @CachePut(key = "#id",value = "Customer")
    public Customer update(long id, Customer customer)
    {
        Customer customer1=customerRepo.findById(id);
      customer1.setName(customer.getName());
      customer1.setExternalId(customer.getExternalId());
      customerRepo.updateCustomer(customer1);
      return customer1;
    }
}
