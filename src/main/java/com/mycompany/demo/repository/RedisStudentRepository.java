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
// public class RedisStudentRepository {

//     private static final String STUDENT_PREFIX = "sss::";

//     private final RedisConnectionFactory redisConnectionFactory;
//     private final ObjectMapper objectMapper;

//     @Autowired
//     public RedisStudentRepository(RedisConnectionFactory redisConnectionFactory, ObjectMapper objectMapper) {
//         this.redisConnectionFactory = redisConnectionFactory;
//         this.objectMapper = objectMapper;
//     }
    
 
//   @CachePut(value = "sss", key = "#student.id")
//   public Student save(Student student) {
//       return student;
//   }

//     // public List<Student> findAllStudents() {
//     //     List<Student> students = new ArrayList<>();
//     //     try (RedisConnection connection = redisConnectionFactory.getConnection()) {
//     //         Set<byte[]> keys = connection.keyCommands().keys((STUDENT_PREFIX + "*").getBytes());
//     //         for (byte[] key : keys) {
//     //             byte[] value = connection.stringCommands().get(key);
//     //             students.add(objectMapper.readValue(value, Student.class));
//     //         }
//     //     } catch (Exception e) {
//     //         throw new RuntimeException("Error retrieving students from Redis", e);
//     //     }
//     //     return students;
//     // }
// }
