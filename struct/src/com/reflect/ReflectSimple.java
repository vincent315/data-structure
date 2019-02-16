package com.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectSimple {
    public static void main(String[] args) throws Exception{
        Class rc = Class.forName("com.reflect.Robot");
        Robot robot =(Robot) rc.newInstance();
        System.out.println(rc.getName());
        Method getHello = rc.getDeclaredMethod("throwHello", String.class);
        getHello.setAccessible(true);

        Object obj = getHello.invoke(robot, "AVC");
        System.out.println(obj);

        Method sayHi = rc.getMethod("sayHi", String.class);
        sayHi.invoke(rc, "Welcome");
        Field name = rc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(rc, "Bob");
        sayHi.invoke(rc, "Welcome");

    }
}
