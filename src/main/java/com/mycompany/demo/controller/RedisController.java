// // package com.mycompany.demo.controller;
// // import com.mycompany.demo.service.RedisService;
// // import org.springframework.web.bind.annotation.*;

// // import java.util.*;

// // @RestController
// // @RequestMapping("/api/redis")
// // public class RedisController {
// //     private final RedisService redisService;

// //     public RedisController(RedisService redisService) {
// //         this.redisService = redisService;
// //     }

    
// //     @PostMapping("/store-multiple")
// //     public String storeMultipleData(@RequestBody Map<String, Object> data) {
// //         redisService.storeMultipleData(data);
// //         return "All data stored successfully!";
// //     }

   
// //     @GetMapping("/get-multiple")
// //     public Map<String, Object> getAllData(@RequestParam List<String> keys) {
// //         return redisService.getAllStoredData(keys);
// //     }
// // }

// package com.mycompany.demo.controller;

// import com.mycompany.demo.model.RedisData;
// import com.mycompany.demo.service.RedisService;
// import org.springframework.web.bind.annotation.*;
// import redis.clients.jedis.Jedis;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// @RestController
// @RequestMapping("/api/redis")
// public class RedisController {
//     private final RedisService redisService;

//     public RedisController(RedisService redisService) {
//         this.redisService = redisService;
//     }

//     @PostMapping("/store-multiple")
//     public String storeMultipleData(@RequestBody List<RedisData> dataList) {
//         for (RedisData data : dataList) {
//             Map<String, Object> singleData = new HashMap<>();
//             singleData.put(data.getKey(), data.getValue());
//             redisService.storeMultipleData(singleData);
//         }
//         return "All data stored successfully!";
//     }

//     @GetMapping("/get-multiple")
//     public List<RedisData> getAllData(@RequestParam(required = false) List<String> keys) {
//         return redisService.getAllStoredData(keys != null ? keys : redisService.getAllKeys());
//     }
// }
