package com.example.learnproject.util

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.learnproject.designmode.singleton.SingletonHungryKotlin.name
import java.lang.StringBuilder
import java.util.*

/**
 * @author: brian
 * @date: 2020/8/8 14:42
 * @description:  kotlin 的扩展函数
 */

/*
class KotlinExtendFunction {}
*/

/*
class  a {
    fun aaa(){
        val test = KotlinExtendFunction::class.java
        testFunction(test)
    }

    private fun testFunction(test: Class<KotlinExtendFunction>) {


    }

}
*/

/*
@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Objects.toStringField(): String {
    val objClass = this::class.java
    val stringBuilder = StringBuilder("${objClass.simpleName} : {\n")
    objClass.declaredFields.forEach {
        it.name
        val value = it.get(objClass).toString()  //TODO 优化， 这里还有很多数据需要处理，例如 类 类型、Array类型
        stringBuilder.append("${it.name} : $value ,\n")
    }
    stringBuilder.append("}")
    return stringBuilder.toString()
}*/

@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Any.toStringField(): String {
    val objClass = this::class.java
    val stringBuilder = StringBuilder("${objClass.simpleName} : {\n")
    objClass.declaredFields.forEach {
        it.isAccessible = true
        val value = it.get(this).toString()  //TODO 优化， 这里还有很多数据需要处理，例如 类 类型、Array类型
        stringBuilder.append("${it.name} : $value ,\n")
    }
    stringBuilder.append("}")
    return stringBuilder.toString()
}