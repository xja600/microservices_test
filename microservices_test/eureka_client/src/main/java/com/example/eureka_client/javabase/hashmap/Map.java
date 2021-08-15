package com.example.eureka_client.javabase.hashmap;

public interface Map<K,V> {

    V put(K k,V v);
    V get(K k);
    int size();
    interface Entry<K,V>{
        K getKey();
        V getValue();
    }
}
