// // package com.mycompany.demo.config;

// // import com.fasterxml.jackson.databind.ObjectMapper;
// // import org.springframework.context.annotation.Bean;
// // import org.springframework.context.annotation.Configuration;
// // import org.springframework.data.redis.connection.RedisConnectionFactory;
// // import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

// // @Configuration
// // public class RedisConfig {


// //     @Bean
// //     public RedisConnectionFactory redisConnectionFactory() {
// //         return new LettuceConnectionFactory("localhost", 6379);
// //     }

// // }
// package com.mycompany.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.redis.connection.RedisConnectionFactory;
// import org.springframework.data.redis.core.RedisTemplate;
// import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
// import org.springframework.data.redis.serializer.StringRedisSerializer;

// // @Configuration
// // public class RedisConfig {

// //     // @Bean
// //     // public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
// //     //     RedisTemplate<String, Object> template = new RedisTemplate<>();
// //     //     template.setConnectionFactory(connectionFactory);
// //     //     template.setKeySerializer(new StringRedisSerializer());
// //     //     template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
// //     //     return template;
// //     // }
// //     @Bean
// // public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
// //     RedisTemplate<String, Object> template = new RedisTemplate<>();
// //     template.setConnectionFactory(connectionFactory);
    
// //     // Use the same serializer for both key and value
// //     GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
// //     template.setKeySerializer(new StringRedisSerializer());
// //     template.setValueSerializer(serializer);
// //     template.setHashKeySerializer(new StringRedisSerializer());
// //     template.setHashValueSerializer(serializer);
    
// //     template.afterPropertiesSet();
// //     return template;
// // }
// // }
// @Configuration
// public class RedisConfig {

//     @Bean
//     public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
//         RedisTemplate<String, Object> template = new RedisTemplate<>();
//         template.setConnectionFactory(connectionFactory);
    
//         GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
//         template.setDefaultSerializer(serializer);
//         template.setKeySerializer(new StringRedisSerializer());
//         template.setValueSerializer(serializer);
//         template.setHashValueSerializer(serializer);
//         template.setHashKeySerializer(new StringRedisSerializer());
    
//         template.afterPropertiesSet();
//         return template;
//     }
    
// }
package com.mycompany.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;

@Configuration
public class RedisConfig {
    @Value("${spring.cache.redis.key-prefix}")
    private String redisPrefix;
    //Custom RedisTemplate with Jackson serializer
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(mapper);

        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);
        template.afterPropertiesSet();

        return template;
    }

    // Custom cache configuration to match RedisTemplate serialization
    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(mapper);
        
        return RedisCacheConfiguration.defaultCacheConfig()
                .prefixCacheNameWith(redisPrefix) // <-- add this
                .entryTtl(Duration.ofMinutes(30)) // Optional: TTL
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));
    }
 
}
