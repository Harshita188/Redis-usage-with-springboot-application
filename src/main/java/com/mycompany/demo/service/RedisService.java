// package com.mycompany.demo.service;

// import org.springframework.stereotype.Service;
// import redis.clients.jedis.Jedis;
// import java.util.*;

// @Service
// public class RedisService {
//     private final Jedis jedis;

//     public RedisService() {
//         this.jedis = new Jedis("localhost", 6379); 
//     }

    
//     public void storeMultipleData(Map<String, Object> data) {
//         for (Map.Entry<String, Object> entry : data.entrySet()) {
//             String key = entry.getKey();
//             Object value = entry.getValue();

//             if (value instanceof String || value instanceof Integer) {
//                 jedis.set(key, value.toString());
//             } else if (value instanceof List) {
//                 jedis.del(key);
//                 for (String item : (List<String>) value) {
//                     jedis.rpush(key, item);
//                 }
//             } else if (value instanceof Map) {
//                 jedis.hset(key, (Map<String, String>) value);
//             } else if (value instanceof Set) {
//                 jedis.sadd(key, ((Set<String>) value).toArray(new String[0]));
//             }
//         }
//     }

 
//     public Map<String, Object> getAllStoredData(List<String> keys) {
//         Map<String, Object> result = new HashMap<>();

//         for (String key : keys) {
//             if (jedis.exists(key)) {
//                 switch (jedis.type(key)) {
//                     case "string":
//                         result.put(key, jedis.get(key));
//                         break;
//                     case "list":
//                         result.put(key, jedis.lrange(key, 0, -1));
//                         break;
//                     case "hash":
//                         result.put(key, jedis.hgetAll(key));
//                         break;
//                     case "set":
//                         result.put(key, jedis.smembers(key));
//                         break;
//                 }
//             }
//         }
//         return result;
//     }
// }

// package com.mycompany.demo.service;

// import com.mycompany.demo.model.RedisData;
// import org.springframework.stereotype.Service;
// import redis.clients.jedis.Jedis;
// import java.sql.Timestamp;
// import java.text.SimpleDateFormat;
// import java.util.*;

// @Service
// public class RedisService {
//     private final Jedis jedis;

//     public RedisService() {
//         this.jedis = new Jedis("localhost", 6379);
//     }
//     public List<String> getAllKeys() {
//         return new ArrayList<>(jedis.keys("*"));
//     }
    
// public void storeMultipleData(Map<String, Object> data) {
//     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

//     for (Map.Entry<String, Object> entry : data.entrySet()) {
//         String key = entry.getKey();
//         Object value = entry.getValue();

//         if (value instanceof String || value instanceof Integer) {
//             jedis.set(key, value.toString());

//         } else if (value instanceof Date || value instanceof Timestamp) {
//             jedis.set(key, dateFormat.format(value));

//         } else if (value instanceof List<?>) {
//             jedis.del(key);
//             for (Object item : (List<?>) value) {
//                 if (item instanceof String) {
//                     jedis.rpush(key, (String) item);
//                 } else {
//                     throw new IllegalArgumentException("List items must be strings.");
//                 }
//             }

//         } else if (value instanceof Map<?, ?>) {
//             Map<String, String> stringMap = new HashMap<>();
//             for (Map.Entry<?, ?> mapEntry : ((Map<?, ?>) value).entrySet()) {
//                 if (mapEntry.getKey() instanceof String && mapEntry.getValue() instanceof String) {
//                     stringMap.put((String) mapEntry.getKey(), (String) mapEntry.getValue());
//                 } else {
//                     throw new IllegalArgumentException("Hash keys and values must be strings.");
//                 }
//             }
//             jedis.hset(key, stringMap);

//         } else if (value instanceof Set<?>) {
//             jedis.sadd(key, ((Set<?>) value).stream().map(Object::toString).toArray(String[]::new));

//         } else {
//             throw new IllegalArgumentException("Unsupported data type: " + value.getClass().getName());
//         }
//     }
// }

//     public List<RedisData> getAllStoredData(List<String> keys) {
//         if (keys == null || keys.isEmpty()) {
//             throw new IllegalArgumentException("Keys list cannot be empty.");
//         }

//         List<RedisData> result = new ArrayList<>();

//         for (String key : keys) {
//             if (jedis.exists(key)) {
//                 String type = jedis.type(key);
//                 Object value = switch (type) {
//                     case "string" -> jedis.get(key);
//                     case "list" -> jedis.lrange(key, 0, -1);
//                     case "hash" -> jedis.hgetAll(key);
//                     case "set" -> jedis.smembers(key);
//                     default -> "Unsupported data type";
//                 };
//                 result.add(new RedisData(key, type, value));
//             }
//         }
//         return result;
//     }
// }
