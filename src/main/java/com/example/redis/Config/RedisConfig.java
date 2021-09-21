package com.example.redis.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/*---------------------Redis Configuration connect to the server----------------*/
@Configuration
@EnableRedisRepositories
public class RedisConfig
{
    /*Jedis Connection Factory--->Connect to redis*/
    @Bean
     public JedisConnectionFactory jedisConnectionFactory()
     {
         RedisStandaloneConfiguration redisStandaloneConfiguration=new RedisStandaloneConfiguration();
         redisStandaloneConfiguration.setHostName("127.0.0.1");
         redisStandaloneConfiguration.setPort(6379);
         JedisConnectionFactory jedisConnectionFactory=new JedisConnectionFactory(redisStandaloneConfiguration);
         return jedisConnectionFactory;
     }

    /*Redis Template --->Used to Interact with Redis server using Jedis Connection to store data*/

    @Bean
    public RedisTemplate<String,Object> redisTemplate()
     {
         RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
         redisTemplate.setConnectionFactory(jedisConnectionFactory());
         redisTemplate.setKeySerializer(new StringRedisSerializer());
         redisTemplate.setHashKeySerializer(new StringRedisSerializer());
         redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
         redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
         redisTemplate.setEnableTransactionSupport(true);
         redisTemplate.afterPropertiesSet();
         return redisTemplate;
     }




}