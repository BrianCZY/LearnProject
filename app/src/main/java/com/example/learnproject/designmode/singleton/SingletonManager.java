package com.example.learnproject.designmode.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: brian
 * @date: 2020/8/1 16:34
 * @description:
 */
public class SingletonManager {
    //单例模式 容器管理  参考 android源码设计模式
    private static Map<String, Object> objMap = new HashMap<String, Object>();

    private SingletonManager() {

    }

    public static void registerService(String key, Object obj) {
        if (!objMap.containsKey(key)) {
            objMap.put(key, obj);
        }
    }

    public static Object getService(String key) {
        return objMap.get(key);
    }
}
