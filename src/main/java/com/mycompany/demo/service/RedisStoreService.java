// package com.mycompany.demo.service;

// import com.mycompany.demo.model.RedisStore;
// import org.springframework.cache.annotation.Cacheable;
// import org.springframework.cache.annotation.CachePut;
// import org.springframework.cache.annotation.CacheEvict;
// import org.springframework.stereotype.Service;

// import java.util.HashMap;
// import java.util.Map;

// @Service
// public class RedisStoreService {

//     private final Map<String, RedisStore> fakeDB = new HashMap<>();

//     @Cacheable(value = "myCache", key = "#id")
//     public RedisStore getById(String id) {
//         System.out.println("Fetching from fake DB");
//         return fakeDB.get(id);
//     }

//     @CachePut(value = "myCache", key = "#store.id")
//     public RedisStore save(RedisStore store) {
//         System.out.println("Saving to fake DB and cache");
//         fakeDB.put(store.getId(), store);
//         return store;
//     }

//     @CacheEvict(value = "myCache", key = "#id")
//     public void delete(String id) {
//         System.out.println("Deleting from fake DB and cache");
//         fakeDB.remove(id);
//     }
// }
