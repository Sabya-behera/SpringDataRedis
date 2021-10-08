package com.example.redis.Repositiory;

import com.example.redis.Model.Customer;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CustomerRepoImpl {

    private static final String key = "Customer";       //to Store data one of the hash

    private HashOperations hashOperations;
    private RedisTemplate<Integer,Customer> redisTemplate;

    public CustomerRepoImpl(RedisTemplate<Integer,Customer> redisTemplate)
    {
        this.redisTemplate=redisTemplate;
         hashOperations = redisTemplate.opsForHash();
    }

    /*------------Add Customer-----------*/
    public Customer  saveCustomer(Customer customer)
    {
        hashOperations.put(key,customer.getId(),customer);
        return  customer;
    }

    /*------------Get all Customer-----------*/
    public Map<Long,Customer> findAll(){
        System.out.println("All from database");
        return  hashOperations.entries(key);
    }
    /*------------Get by  IdCustomer-----------*/
    public Customer findById(long id)
    {
        System.out.println("Called findById from db");
        return (Customer) hashOperations.get(key,id);
    }

    /*------------Delete Customer-----------*/
    public String deleteById(long id)
    {
         hashOperations.delete(key,id);
        return  "Deleted";
    }

    public String updateCustomer( long id,Customer customer)
    {
        hashOperations.put(key,id,customer);
      //  hashOperations.put(key,customer.getExternalId(),customer);
        return "Updated";
    }




}
