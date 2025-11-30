// package com.mycompany.demo.repository;

// import com.mycompany.demo.model.*;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.cache.annotation.CachePut;
// import org.springframework.data.redis.connection.RedisConnection;
// import org.springframework.data.redis.connection.RedisConnectionFactory;
// import org.springframework.stereotype.Service;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Set;

// @Service
// public class RedisUserRepository {

//     private static final String USER_PREFIX = "user::";

//     private final RedisConnectionFactory redisConnectionFactory;
//     private final ObjectMapper objectMapper;

//     @Autowired
//     public RedisUserRepository(RedisConnectionFactory redisConnectionFactory, ObjectMapper objectMapper) {
//         this.redisConnectionFactory = redisConnectionFactory;
//         this.objectMapper = objectMapper;
//     }
    
//     @CachePut(value = "users", key = "#user.id")
//     public User save(User user) {
//     return user;
//     }

//     public List<User> findAllUsers() {
//         List<User> users = new ArrayList<>();
//         try (RedisConnection connection = redisConnectionFactory.getConnection()) {
//             Set<byte[]> keys = connection.keyCommands().keys((USER_PREFIX + "*").getBytes());
//             for (byte[] key : keys) {
//                 byte[] value = connection.stringCommands().get(key);
//                 users.add(objectMapper.readValue(value, User.class));
//             }
//         } catch (Exception e) {
//             throw new RuntimeException("Error retrieving users from Redis", e);
//         }
//         return users;
//     }
// }
