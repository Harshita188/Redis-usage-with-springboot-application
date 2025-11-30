// package com.mycompany.demo.service;

// import com.mycompany.demo.model.UserCrudUser;
// import com.mycompany.demo.repository.UserCrudUserRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;

// import java.util.Optional;

// @Service
// @RequiredArgsConstructor
// public class UserCrudUserService {

//     private final UserCrudUserRepository userRepository;

//     public UserCrudUser save(UserCrudUser user) {
//         return userRepository.save(user);
//     }

//     public Optional<UserCrudUser> findById(String id) {
//         return userRepository.findById(id);
//     }

//     public Iterable<UserCrudUser> findAll() {
//         return userRepository.findAll();
//     }

//     public void deleteById(String id) {
//         userRepository.deleteById(id);
//     }
// }
