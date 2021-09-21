package com.example.redis.Repositiory;

import com.example.redis.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepoImpl {

    private static final String key = "Customer";       //to Store data one of the hash
    @Autowired
    private RedisTemplate redisTemplate;

    /*------------Add Customer-----------*/
    public Customer  saveCustomer(Customer customer)
    {
        redisTemplate.opsForHash().put("Key",customer.getId(),customer);
        return  customer;
    }

    /*------------Get all Customer-----------*/
    public List<Customer> findAll()
    {
        return redisTemplate.opsForHash().values(key);
    }

    /*------------Get by  IdCustomer-----------*/
    public Customer findById(int id)
    {
        System.out.println("Called findById from db");
        return (Customer) redisTemplate.opsForHash().get(key,id);
    }

    /*------------Delete Customer-----------*/
    public String deleteById(long id)
    {
         redisTemplate.opsForHash().delete(key,id);
        return  "Deleted";
    }

    public String updateCustomer( Customer customer)
    {
        redisTemplate.opsForHash().put("key1",customer.getName(),customer);
        redisTemplate.opsForHash().put("key2",customer.getExternalId(),customer);
        return "Updated";
    }




}
