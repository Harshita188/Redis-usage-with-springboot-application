// package com.mycompany.demo.controller;


// import com.mycompany.demo.model.Student;
// import com.mycompany.demo.model.User;
// import com.mycompany.demo.repository.RedisStudentRepository;
// import com.mycompany.demo.repository.RedisUserRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api")
// public class ApiController {

//     @Autowired
//     private RedisUserRepository userRepo;

//     @Autowired
//     private RedisStudentRepository studentRepo;

//     @PostMapping("/user")
//     public ResponseEntity<String> addUser(@RequestBody User user) {
//         userRepo.save(user);
//         return ResponseEntity.ok("User saved");
//     }

//     @PostMapping("/student")
//     public ResponseEntity<String> addStudent(@RequestBody Student student) {
//         studentRepo.save(student);
        
//         return ResponseEntity.ok("Student saved");
//     }

//     // @GetMapping("/students")
//     // public ResponseEntity<List<Student>> getAllStudents() {
//     //     return ResponseEntity.ok(studentRepo.findAllStudents());
//     // }

//     @GetMapping("/users")
//     public ResponseEntity<List<User>> getAllUsers() {
//         return ResponseEntity.ok(userRepo.findAllUsers());
//     }
// }
