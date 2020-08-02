package com.example.learnproject.designmode.singleton

/**
 * @author: brian
 * @date: 2020/8/1 14:48
 * @description:
 */
enum class SingletonEnumKotlin {
    INSTANCE;

    //单例模式 内部类
    var name2 = ""

    fun init() {
        name2 = SingletonEnumKotlin::class.java.simpleName
    }

}