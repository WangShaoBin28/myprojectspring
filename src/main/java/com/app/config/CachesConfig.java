package com.app.config;

import com.google.common.collect.Lists;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashSet;

/**
 * 缓存管理（注解用）
 *
 * @author Administrator
 */
@Configuration
@EnableCaching
public class CachesConfig extends CachingConfigurerSupport {

    /**
     * 管理缓存
     *
     * @param redisConnectionFactory
     * @return
     */
    @SuppressWarnings("rawtypes")
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        // 设置缓存有效期一小时
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofHours(1));
        return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).initialCacheNames(new HashSet<>(Lists.newArrayList("therapyOrder",
                        "suitConfigTreatment",
                        "therapyStep"))).build();
    }

    /**
     * 生成key的策略
     *
     * @return
     */
    @Override
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    if (obj != null) {
                        sb.append(obj.toString());
                    }
                }
                System.out.println(sb.toString());
                return sb.toString();
            }
        };
    }


}