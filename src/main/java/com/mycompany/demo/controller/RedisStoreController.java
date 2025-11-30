// package com.mycompany.demo.controller;

// import com.mycompany.demo.model.RedisStore;
// import com.mycompany.demo.service.RedisStoreService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/redis-store")
// public class RedisStoreController {

//     private final RedisStoreService redisStoreService;

//     public RedisStoreController(RedisStoreService redisStoreService) {
//         this.redisStoreService = redisStoreService;
//     }

//     @PostMapping
//     public RedisStore save(@RequestBody RedisStore store) {
//         return redisStoreService.save(store);
//     }

//     @GetMapping("/{id}")
//     public RedisStore getById(@PathVariable String id) {
//         return redisStoreService.getById(id);
//     }

//     @DeleteMapping("/{id}")
//     public String delete(@PathVariable String id) {
//         redisStoreService.delete(id);
//         return "Deleted successfully!";
//     }
// }
