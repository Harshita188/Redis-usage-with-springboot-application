// package com.mycompany.demo.controller;

// import com.mycompany.demo.model.*;
// import com.mycompany.demo.service.UserCrudUserService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/users")
// @RequiredArgsConstructor
// public class UserCrudUserController {

//     private final UserCrudUserService userService;

//     @PostMapping
//     public ResponseEntity<UserCrudUser> saveUser(@RequestBody UserCrudUser user) {
//         return ResponseEntity.ok(userService.save(user));
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<UserCrudUser> getUser(@PathVariable String id) {
//         return userService.findById(id)
//                 .map(ResponseEntity::ok)
//                 .orElse(ResponseEntity.notFound().build());      
//     }

//     @GetMapping
//     public ResponseEntity<Iterable<UserCrudUser>> getAllUsers() {
//         return ResponseEntity.ok(userService.findAll());
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteUser(@PathVariable String id) {
//         userService.deleteById(id);
//         return ResponseEntity.noContent().build();
//     }
// }
