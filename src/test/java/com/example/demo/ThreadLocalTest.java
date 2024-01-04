package com.example.demo;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {

    @Test
    public void testThread(){
        ThreadLocal tl = new ThreadLocal();
        new Thread(()->{
            tl.set("xiaoyan");
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
        },"blue").start();

        new Thread(()->{
            tl.set("yaocheng");
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
        },"green").start();
    }
}
