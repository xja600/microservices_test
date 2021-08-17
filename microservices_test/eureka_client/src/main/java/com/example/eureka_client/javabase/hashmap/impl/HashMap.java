package com.example.eureka_client.javabase.hashmap.impl;

import com.example.eureka_client.javabase.hashmap.Map;


/**
 * 参考资料：https://www.bilibili.com/video/BV1x5411T7C2?p=6
 * 重写HashMap,熟悉hashMap的运行原理
 * @param <K>
 * @param <V>
 */
public class HashMap<K,V> implements Map<K,V> {

    Entry<K,V>[] table = null;
    int size = 0;

    /**
     * 构造方法，默认16长度
     */
    public HashMap(){
        table = new Entry[16];
    }

    /**
     * 1、通过传入的K的值，取模，算出它的hashCode
     * 2、拿它算出的hashCode的值当作数组的下标去找对应的值
     * 3、如果为空，没有不冲突，直接用数组来存它的值
     * 4、如果不为空，冲突，需要用链表来存它的值
     * 5、然后返回V
     * @param k
     * @param v
     * @return
     */
    @Override
    public V put(K k, V v) {
        int index = hash(k);
        Entry entry = table[index];
        //如果用这个下标找不出值来，则证明不冲突，直接用数组存储
        if(null == entry){
            //查不到，把赋值好的对象，直接给该数组
            table[index] = new Entry<K, V>(k,v,index,null);
            size++;
        }else {
            //如果有值，证明冲突了，用链表来存
            table[index] = new Entry<K, V>(k,v,index,entry);
        }
        return table[index].getValue();
    }

    /**
     * 获取K值的hash值，再对该值取模，负数的话，修改为正数
     * @param k
     * @return
     */
    public int hash(K k){
        //取模
        int i = k.hashCode()%15;
        return i>=0?i : -i;
    }

    /**
     * 1、算出K的hash
     * 2、数组查询
     * 3、判断K的hash是否相等，如果相等证明找到了，返回
     * 4、如果不相等，判断next是否为空，不为空继续比较是否相等
     * 5、直到相等或者为null才终止
     * @param k
     * @return
     */
    @Override
    public V get(K k) {
        if(size == 0){
            return null;
        }
        int index = hash(k);
        Entry<K,V> entry = findValue(table[index],k);
        return entry == null ? null:entry.getValue();
    }

    public Entry<K,V> findValue(Entry<K,V> entry,K k){

        //比较是否存在这个链表
        if(k.equals(entry.getKey()) || k==entry.getKey()){
            return entry;
        }else {
            //如果不为空，继续往下走
            if(entry.next != null){
                return findValue(entry.next,k);
            }
        }

        return null;
    }
    @Override
    public int size() {
        return size;
    }


    /**
     * 实现手写的Map的内部接口，强制执行该内部类
     * @param <K>
     * @param <V>
     */
    class Entry<K,V> implements Map.Entry<K,V>{
        K k;
        V v;
        int hash;
        Entry<K,V> next;//指向下一个链表

        public Entry(K k, V v, int hash, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }
}
