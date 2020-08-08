package com.example.learnproject.designmode.builder

import com.example.learnproject.bean.DailyReport
import com.example.learnproject.bean.Report

/**
 * @author: brian
 * @date: 2020/8/2 16:31
 * @description:
 */
class DailyReportBuilder : Builder() {
    val mDailyReport = DailyReport()
    override fun buildTile() {
        mDailyReport.initTile()
    }

    override fun buildDay(day: String) {
        mDailyReport.mDay = day
    }

    override fun buildContent(content: String) {
        mDailyReport.mContent = content
    }

    override fun create(): Report {

        return mDailyReport
    }
}