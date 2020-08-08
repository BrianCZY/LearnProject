package com.example.learnproject.bean

/**
 * @author: brian
 * @date: 2020/8/2 16:01
 * @description:
 */
abstract class Report {
    // Report 抽象类可要可不要

    var mTile: String? = null //报告标题
    var mDay: String? = null //报告类型
    var mContent: String? = null //报告内容

    abstract fun initTile()

    fun buildReport(): String {
        return "Tile : ${mTile} \n Day : ${mDay} \n Content : ${mContent}"
    }
}