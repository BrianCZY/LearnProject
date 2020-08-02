package com.example.learnproject.designmode.builder

/**
 * @author: brian
 * @date: 2020/8/2 16:38
 * @description:
 */

class Director(var mBuilder: Builder) {
    //负责构造

    var mTile: String? = null //报告标题
    var mDay: String? = null //报告类型
    var mContent: String? = null //报告内容
    fun construct(day: String, content: String) {
        mBuilder.buildTile()
        mBuilder.buildDay(day)
        mBuilder.buildContent(content)
    }


}