package com.example.learnproject.designmode

/**
 * @author: brian
 * @date: 2020/8/1 14:48
 * @description:
 */
class SingletonLazyKotlin private constructor() {
    var name = ""
    fun init() {
        name = SingletonLazyKotlin::class.java.simpleName
    }

    companion object {
        //单例模式 懒汉
        @get:Synchronized  //同步
        var instance: SingletonLazyKotlin? = null
            get() {
                if (field == null) { //
                    field =
                        SingletonLazyKotlin()
                }
                return field
            }

    }
}
