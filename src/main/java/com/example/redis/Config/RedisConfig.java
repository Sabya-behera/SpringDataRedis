package com.example.redis.Config;


import com.example.redis.Model.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/*---------------------Redis Configuration connect to the server(Database)----------------*/
@Configuration
//@EnableRedisRepositories
public class RedisConfig
{
    /*Jedis Connection Factory--->Connect to redis*/
    @Bean
     public JedisConnectionFactory jedisConnectionFactory()
     {
                          //         RedisStandaloneConfiguration redisStandaloneConfiguration=new RedisStandaloneConfiguration();
                         //         redisStandaloneConfiguration.setHostName("127.0.0.1");
                        //         redisStandaloneConfiguration.setPort(6379);
                       //         JedisConnectionFactory jedisConnectionFactory=new JedisConnectionFactory(redisStandaloneConfiguration);
         return new JedisConnectionFactory();
     }

    /*Redis Template --->Used to Interact with Redis server using Jedis Connection to store data*/

    @Bean
    public RedisTemplate<Integer,Customer> redisTemplate()
     {
         RedisTemplate<Integer,Customer> redisTemplate=new RedisTemplate<>();
         redisTemplate.setConnectionFactory(jedisConnectionFactory());
                     //         redisTemplate.setKeySerializer(new StringRedisSerializer());
                    //         redisTemplate.setHashKeySerializer(new StringRedisSerializer());
                   //         redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
                  //         redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
                 //         redisTemplate.setEnableTransactionSupport(true);
                //         redisTemplate.afterPropertiesSet();
         return redisTemplate;
     }

}
