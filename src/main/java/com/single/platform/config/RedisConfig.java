package com.single.platform.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author: 吴邪
 * @date: 2020/5/19 15:36
 */
@Configuration
public class RedisConfig {

//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofHours(2)); // 设置缓存有效期两小时
//        return RedisCacheManager
//                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
//                .cacheDefaults(redisCacheConfiguration).build();
//    }
}
