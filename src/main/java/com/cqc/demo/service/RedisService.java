package com.cqc.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 保存数据
    public void save(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // 获取数据
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // 删除数据

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    // 操作哈希
    public void saveToHash(String hash, String key, Object value) {
        redisTemplate.opsForHash().put(hash, key, value);
    }

    public Object getFromHash(String hash, String key) {
        return redisTemplate.opsForHash().get(hash, key);
    }
}

