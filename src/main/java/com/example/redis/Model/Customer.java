package com.example.redis.Model;


import java.io.Serializable;


//@Data
//@RedisHash("Customer")
public class Customer implements Serializable {                //used to serialize and deserialize objects to json and vice-versa

    private Long id;
    private String externalId;
    private String name;

    public Customer() {
    }

    public Customer(Long id, String externalId, String name) {
        this.id = id;
        this.externalId = externalId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public String toString() {
//        return "CustomerRepo{" +
//                "id=" + id +
//                ", externalId='" + externalId + '\'' +
//                ", name='" + name + '\'' +
//                '}';
//    }
}