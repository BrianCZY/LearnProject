package com.example.learnproject.designmode.builder

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.learnproject.util.toStringField
import java.util.*

/**
 * @author: brian
 * @date: 2020/8/8 11:25
 * @description:
 */
class ReportLink {
    //Builder模式（建造者）  链式建造
    //优点
    //其一，使用简单，可以在不需要知道内部构建细节的情况下，构建出复杂的对象模型；
    //其二，解耦的，可以将构建的过程和具体的表示分离开来。
    //使用场景
    //一个对象建造起来比较复杂时，比如参数多，很多参数具有默认值
    //产品类非常复杂，或者产品类中的调用顺序不同产生了不同的作用

    var mTile: String? = null //报告标题
    var mDay: String? = null //报告日期
    var mContent: String? = null //报告内容
    var mNextPlan: String? = null //明天计划
    var mSubmitDate: String? = null //提交日期
    var mPerson: String? = null //提交人

/*    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun toString(): String {
        return "mTile:$mTile \n mDay:$mDay \n  mContent:$mContent \n mNextPlan:$mNextPlan \n  mSubmitDate:$mSubmitDate \n  mPerson:$mPerson "

        this.toStringField()

    }*/

    class Builder {
        var mTile: String? = null //报告标题
        var mDay: String? = null //报告日期
        var mContent: String? = null //报告内容
        var mNextPlan: String? = null //明天计划
        var mSubmitDate: String? = null //提交日期
        var mPerson: String? = null //提交人

        fun builderTile(tile: String): Builder {
            mTile = tile
            return this
        }

        fun builderDay(day: String): Builder {
            mDay = day
            return this
        }

        fun builderContent(content: String): Builder {
            mContent = content
            return this
        }

        fun builderNextPlan(nextPlan: String): Builder {
            mNextPlan = nextPlan
            return this
        }

        fun buildersubmitDate(submitDate: String): Builder {
            mSubmitDate = submitDate
            return this
        }

        fun builderPerson(peron: String): Builder {
            mPerson = peron
            return this
        }

        fun create(): ReportLink {
            val reportLink = ReportLink()
            reportLink.mTile = this.mTile
            reportLink.mDay = this.mDay
            reportLink.mContent = this.mContent
            reportLink.mNextPlan = this.mNextPlan

            if (this.mSubmitDate.isNullOrEmpty()) {
                // 为空则使用当前时间
                reportLink.mSubmitDate = System.currentTimeMillis().toString()
            } else {
                reportLink.mSubmitDate = this.mSubmitDate
            }

            reportLink.mPerson = this.mPerson
            return reportLink
        }
    }


}