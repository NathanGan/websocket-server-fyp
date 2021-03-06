package com.service;

/**
 * Created by nathan on 2017/11/16.
 */
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import com.service.RedisService;
import com.util.JSONUtil;
import com.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;


@Component("redisService")
public class RedisServiceImpl implements RedisService {

    private StringRedisTemplate redisTemplate;
    @Bean(name="jedisConnectionFactory")
    @Autowired
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        return factory;
    }
    @Autowired
    public RedisServiceImpl(){
        this.redisTemplate = new StringRedisTemplate(jedisConnectionFactory());
    }

    @Autowired
    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = new StringRedisTemplate(jedisConnectionFactory());
    }

    public <T> void put(String key, T obj) {
        redisTemplate.opsForValue().set(key, JSONUtil.toJSON(obj));
    }

    public <T> void put(String key, T obj, int timeout) {
        put(key, obj, timeout, TimeUnit.MINUTES);
    }

    public <T> void put(String key, T obj, int timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, JsonUtils.toJson(obj), timeout, unit);
    }

    public <T> T get(String key, Class<T> cls) {
        return JsonUtils.fromJson(redisTemplate.opsForValue().get(key), cls);
    }

    public <E, T extends Collection<E>> T get(String key, Class<E> cls, Class<T> collectionClass) {
        return JsonUtils.fromJson(redisTemplate.opsForValue().get(key), cls, collectionClass);
    }

    public <T> T putIfAbsent(String key, Class<T> cls, Supplier<T> supplier) {
        T t = get(key, cls);
        if (t == null) {
            t = supplier.get();
            if (t != null) {
                put(key, t);
            }
        }
        return t;
    }

    public <T> T putIfAbsent(String key, Class<T> cls, Supplier<T> supplier, int timeout) {
        T t = get(key, cls);
        if (t == null) {
            t = supplier.get();
            if (t != null) {
                put(key, t, timeout);
            }
        }
        return t;
    }

    public <T> T putIfAbsent(String key, Class<T> cls, Supplier<T> supplier, int timeout, TimeUnit unit) {
        T t = get(key, cls);
        if (t == null) {
            t = supplier.get();
            if (t != null) {
                put(key, t, timeout, unit);
            }
        }
        return t;
    }

    public <T> T putIfAbsent(String key, Class<T> cls, Supplier<T> supplier, int timeout, TimeUnit unit, boolean refresh) {
        T t = get(key, cls);
        if (t == null) {
            t = supplier.get();
            if (t != null) {
                put(key, t, timeout, unit);
            }
        } else {
            if (refresh) {
                expire(key, timeout, unit);
            }
        }
        return t;
    }

    public <E, T extends Collection<E>> T putIfAbsent(String key, Class<E> cls, Class<T> collectionCls, Supplier<T> supplier) {
        T t = get(key, cls, collectionCls);
        if (t == null || t.isEmpty()) {
            t = supplier.get();
            if (t != null && t.size() > 0) {
                put(key, t);
            }
        }
        return t;
    }

    public <E, T extends Collection<E>> T putIfAbsent(String key, Class<E> cls, Class<T> collectionCls, Supplier<T> supplier, int timeout) {
        return putIfAbsent(key, cls, collectionCls, supplier, timeout, TimeUnit.SECONDS);
    }

    public <E, T extends Collection<E>> T putIfAbsent(String key, Class<E> cls, Class<T> collectionCls, Supplier<T> supplier, int timeout, TimeUnit unit) {
        return putIfAbsent(key, cls, collectionCls, supplier, timeout, unit, false);
    }

    public <E, T extends Collection<E>> T putIfAbsent(String key, Class<E> cls, Class<T> collectionCls, Supplier<T> supplier, int timeout, TimeUnit unit, boolean refresh) {
        T t = get(key, cls, collectionCls);
        if (t == null || t.isEmpty()) {
            t = supplier.get();
            if (t != null && t.size() > 0) {
                put(key, t, timeout, unit);
            }
        } else {
            if (refresh) {
                expire(key, timeout, unit);
            }
        }
        return t;
    }


    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public boolean expire(String key, long timeout, TimeUnit timeUnit) {
        return redisTemplate.expire(key, timeout, timeUnit);
    }

    public boolean expire(String key, long timeout) {
        return expire(key, timeout, TimeUnit.MINUTES);
    }

    public void put(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void put(String key, String value, int timeout) {
        put(key, value, timeout, TimeUnit.MINUTES);
    }

    public void put(String key, String value, int timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }


    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

}