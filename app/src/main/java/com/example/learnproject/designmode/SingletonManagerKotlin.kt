package com.example.learnproject.designmode

import java.util.*

/**
 * @author: brian
 * @date: 2020/8/1 16:34
 * @description:
 */
object SingletonManagerKotlin {
    //单例模式 容器管理  参考 android源码设计模式
    private val objMap: MutableMap<String, Any> = HashMap()

    fun registerService(key: String, obj: Any) {
        if (!objMap.containsKey(key)) {
            objMap[key] = obj
        }
    }

    fun getService(key: String): Any? {
        return objMap[key]
    }
}