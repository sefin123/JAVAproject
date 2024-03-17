package com.api.component;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Cache {

    private Map<String, Object> cacheMap = new HashMap<>();

    public Cache() {
        cacheMap = new ConcurrentHashMap<>();
    }

    public void put(String key, Object value) {
        cacheMap.put(key, value);
    }

    public Object get(String key) {
        return cacheMap.get(key);
    }

    public void remove(String key) {
        cacheMap.remove(key);
    }

    public void clear() {
        cacheMap.clear();
    }
}
