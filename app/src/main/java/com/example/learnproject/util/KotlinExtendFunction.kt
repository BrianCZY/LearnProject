package com.example.learnproject.util

import java.lang.reflect.Array


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


fun Any.anyToString(): String {
    val objClass: Class<*> = this.javaClass
    val stringBuilder = StringBuilder()
    /**
     * 对于基本数据类型和String直接返回
     */
    if (this is Int || this is Int || this is Byte
        || this is Long || this is Double || this is Float
        || this is Boolean || this is String || this is Char
    ) { // 基本类型
        stringBuilder.append("$this ")

    } else if (objClass.isArray) {//数组
        stringBuilder.append("[")
        val length = Array.getLength(this)
        for (i in 0..length - 1) {
            try {
                val obj = Array.get(this, i)
//            obj.anyToString()
                if (obj == null) {
//                    stringBuilder.append("")
                } else {
                    if (i > 0) {
                        stringBuilder.append(",")
                    }
                    stringBuilder.append(obj.anyToString())

                }

            } catch (e: IllegalStateException) {
                e.printStackTrace()
            }


        }

        stringBuilder.append("]")


    } else {  //对象
        stringBuilder.append("{\n")
        objClass.declaredFields.forEachIndexed { index, field ->
            field.isAccessible = true
            val value = field.get(this)
            if (index > 0) {
                stringBuilder.append(",\n")
            }
            if (field.type.isPrimitive || field.type == String.javaClass) {
                stringBuilder.append("${field.name} : ${value}")
            } else {
                stringBuilder.append("${field.name} : ${value.anyToString()}")
            }


        }

        stringBuilder.append("\n}")
    }


    return stringBuilder.toString()

}
