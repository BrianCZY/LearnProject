package com.example.learnproject

/**
 * @author: brian
 * @date: 2020/8/8 11:42
 * @description:
 */

class TestKotlin {

    fun test(obj: Any): String? {
        val strBuf = StringBuffer()
        val cla: Class<*> = obj.javaClass
        /**
         * 对于基本数据类型和String直接返回
         */
        if (cla == Int::class.java || cla == Short::class.java || cla == Byte::class.java || cla == Long::class.java || cla == Double::class.java || cla == Float::class.java || cla == Boolean::class.java || cla == String::class.java || cla == Char::class.java
        ) {
            strBuf.append(obj)
            return strBuf.toString()
        }
        return ""
    }
}

