// package com.mycompany.demo.service; 

// import org.springframework.cache.annotation.Cacheable;
// import org.springframework.stereotype.Service;
// import java.util.concurrent.TimeUnit;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

// @Service
// public class DataService {
//     private static final Logger logger = LoggerFactory.getLogger(DataService.class);

//     @Cacheable(value = "myCache", key = "#id")  
//     public String getData(int id) {
//         logger.info("Fetching data for ID: {}", id);  
//         simulateSlowService();  
//         return "Data for ID: " + id;
//     }

//     private void simulateSlowService() {
//         try {
//             TimeUnit.SECONDS.sleep(5); 
//         } catch (InterruptedException e) {
//             Thread.currentThread().interrupt();
//         }
//     }
// }
