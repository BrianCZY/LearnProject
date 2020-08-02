package com.example.learnproject.designmode.singleton

/**
 * @author: brian
 * @date: 2020/8/1 14:48
 * @description:
 */
class SingletonInnerKotlin {
    //单例模式 内部类
    var name = ""


    private object SingletonHolder {
        val instance =
            SingletonInnerKotlin()
    }

    fun init() {
        name = SingletonInnerKotlin::class.java.simpleName
    }

    companion object {
        val instance =
            SingletonHolder.instance
    }
}