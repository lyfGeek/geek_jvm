package com.geek.geek_my;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadLocal<T> {

    static AtomicInteger atomicInteger = new AtomicInteger();
    //    static HashMap<Thread, HashMap<MyThreadLocal<?>, Object>> threadLocalMap = new HashMap<>();
    static HashMap<Thread, HashMap<Integer, Object>> threadLocalMap = new HashMap<>();
    Integer threadLocalHash = atomicInteger.addAndGet(0x61c88647);

    //    synchronized static HashMap<MyThreadLocal<?>, Object> getMap() {
    synchronized static HashMap<Integer, Object> getMap() {
        Thread thread = Thread.currentThread();
        if (!threadLocalMap.containsKey(thread)) {
            threadLocalMap.put(thread, new HashMap<Integer, Object>());
        }
        return threadLocalMap.get(thread);
    }

    protected T initialValue() {
        return null;
    }

    public T get() {
//        HashMap<MyThreadLocal<?>, Object> map = getMap();
        HashMap<Integer, Object> map = getMap();

        if (!map.containsKey(this.threadLocalHash)) {
            map.put(this.threadLocalHash, initialValue());
        }

        return (T) map.get(this.threadLocalHash);

        /*if (!map.containsKey(this)) {
            map.put(this, initialValue());
        }
        return (T) map.get(this);*/
    }

    public void set(T v) {
//        HashMap<MyThreadLocal<?>, Object> map = getMap();
        HashMap<Integer, Object> map = getMap();
//        map.put(this, v);
        map.put(threadLocalHash, v);
    }
}
