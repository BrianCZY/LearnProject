package com.example.learnproject.bean

/**
 * @author: brian
 * @date: 2020/8/2 16:05
 * @description: 日报
 */

class DailyReport : Report() {
    //具体的报告类型
    val TAG = DailyReport::class.java.simpleName

    override fun initTile() {
        mTile = "$TAG"
    }


}