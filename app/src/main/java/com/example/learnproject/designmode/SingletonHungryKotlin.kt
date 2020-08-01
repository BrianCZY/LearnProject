package com.example.learnproject.designmode

/**
 * @author: brian
 * @date: 2020/8/1 14:48
 * @description: 
 */
object SingletonHungryKotlin {
    //单例模式 饿汉
    var name: String? = null
    fun init() {
        name = SingletonHungryKotlin::class.java.simpleName

    }

}