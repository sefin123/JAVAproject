package com.api.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CacheTest {

    private Cache cache;

    @BeforeEach
    void setUp() {
        cache = new Cache();
    }

    @Test
    void getAndPutTest() {
        String key = "Test key";
        String value = "Test value";

        cache.put(key, value);

        assertEquals(value, cache.get(key));
    }

    @Test
    void removeTest() {
        String key = "key";
        String value = "value";

        cache.put(key, value);
        cache.remove(key);

        assertNull(cache.get(key));
    }

    @Test
    void testClear() {
        String key1 = "key1";
        String value1 = "value1";
        String key2 = "key2";
        String value2 = "value2";

        cache.put(key1, value1);
        cache.put(key2, value2);
        cache.clear();

        assertNull(cache.get(key1));
        assertNull(cache.get(key2));
    }

}