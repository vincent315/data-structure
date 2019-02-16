package com.reflect;

public class Robot {
    private String name;
    public void sayHi(String hello){
        System.out.println(hello +  " " + name);
    }

    private String throwHello(String hello){
        return "hello" + hello;
    }
}
