package com.yayayahei.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadId {

    private static final AtomicInteger nextId = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadId = new ThreadLocal<>() {
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };
    public static int get(){
        return threadId.get();
    }
}
