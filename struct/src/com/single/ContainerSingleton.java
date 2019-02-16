package com.single;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一管理，节省资源，容器单例
 */
public class ContainerSingleton {
    private static Map<String,Object> singletonMap = new HashMap<String, Object>();

    public static void putInstance(String key,Object instance){
        if(!key.isEmpty() && instance !=null){
            if(!singletonMap.containsKey(key)){
                singletonMap.put(key, instance);
            }
        }
    }
    private ContainerSingleton(){

    }
    public static Object getInstance(String key){
        return singletonMap.get(key);
    }


}
