package com.example.learnproject.designmode.singleton

/**
 * @author: brian
 * @date: 2020/8/1 14:48
 * @description:
 */
class SingletonDCLKotlin private constructor() {
    var name = ""

    fun init() {
        name = SingletonDCLKotlin::class.java.simpleName
    }

    /* companion object {
         //单例模式 Double Check Lock  (DCL)
         var instance: SingletonDCLKotlin? = null
             get() {
                 if (field == null) {
                     synchronized(SingletonLazy::class.java) {
                         if (field == null) field = SingletonDCLKotlin()
                     }
                 }
                 return field
             }
     }*/

    //更优的写法
    companion object {
        val instance: SingletonDCLKotlin by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { SingletonDCLKotlin() }
    }
}