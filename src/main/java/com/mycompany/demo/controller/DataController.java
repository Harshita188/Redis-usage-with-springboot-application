// package com.mycompany.demo.controller;
// import com.mycompany.demo.service.DataService;  
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api")
// public class DataController {
//     private final DataService dataService;

//     public DataController(DataService dataService) {
//         this.dataService = dataService;
//     }

//     @GetMapping("/data/{id}")
//     public String getData(@PathVariable int id) {
//         return dataService.getData(id);
//     }
// }