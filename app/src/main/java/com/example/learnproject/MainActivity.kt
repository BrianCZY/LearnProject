package com.example.learnproject

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.example.learnproject.bean.Company
import com.example.learnproject.bean.YearReport
import com.example.learnproject.designmode.builder.DailyReportBuilder
import com.example.learnproject.designmode.builder.Director
import com.example.learnproject.designmode.builder.MonthReportBuilder
import com.example.learnproject.designmode.builder.ReportLink
import com.example.learnproject.designmode.singleton.*
import com.example.learnproject.ui.main.SectionsPagerAdapter
import com.example.learnproject.util.anyToString


class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            test()
        }



    }

    private fun test() {
        testToString()

        testSingletonDesignMode()
        testBuilderDesignMode()
    }

    private fun testToString() {
        //测试通用的toString 方法
        val intType = 2020
        val stringType = "stringType"
        val booleanType = true
        val floatType = 88f
        val shortType: Short = 8
        val byteType = 8.toByte()
        val doubleType = 100.001.toDouble()
        val LongType = 100000.toDouble()
        val charType: Char = 'c'
        val reportLink = ReportLink.Builder()
            .builderTile("开发日志")
            .builderContent("2020-8-8 学习了建造者的链式调用，学习进度延迟！")
            .builderDay("2020-8-8")
            .builderNextPlan("接下来学习原型模式")
//            .buildersubmitDate("2020-8-8") //这里可以设置也可以不设置，内部有默认的，这是Builder模式的优点
            .builderPerson("Brian")
            .create()
//        Log.i(TAG, "testToString intType : ${intType.anyToString()}")
//        Log.i(TAG, "testToString booleanType : ${stringType.anyToString()}")
//        Log.i(TAG, "testToString booleanType : ${booleanType.anyToString()}")
//        Log.i(TAG, "testToString floatType : ${floatType.anyToString()}")
//        Log.i(TAG, "testToString shortType : ${shortType.anyToString()}")
//        Log.i(TAG, "testToString byteType : ${byteType.anyToString()}")
//        Log.i(TAG, "testToString doubleType : ${doubleType.anyToString()}")
//        Log.i(TAG, "testToString LongType : ${LongType.anyToString()}")
//        Log.i(TAG, "testToString charType : ${charType.anyToString()}")
//        Log.i(TAG, "testToString reportLink : ${reportLink.anyToString()}")

        val yearReport: YearReport = YearReport()
        val reports = mutableListOf<ReportLink>()
        reports.add(
            ReportLink.Builder()
                .builderTile("开发日志1")
                .builderContent("测试ToString1！")
                .builderDay("2020-8-8")
                .builderNextPlan("接下来学习原型模式")
                .builderPerson("Brian")
                .create()
        )
        reports.add(
            ReportLink.Builder()
                .builderTile("开发日志2")
                .builderContent("测试ToString2！")
                .builderDay("2020-8-8")
                .builderNextPlan("接下来学习原型模式")
                .builderPerson("Brian")
                .create()
        )
        yearReport.company = Company("Brian测试工程", "广州")
        yearReport.year = "2020-8-8"
        yearReport.reports.addAll(reports)
        yearReport.reportSum = reports.size
//        val mixType = yearReport.anyToString()
        Log.i(TAG, "testToString mixType yearReport : ${yearReport.anyToString()}")

    }

    private fun testBuilderDesignMode() {

        //Builder模式 （建造者） 经典形式
        val dailyReportBuilder = DailyReportBuilder()
        Director(dailyReportBuilder).construct("2020-8-2", "学习建造者模式！")
        val dailyReport = dailyReportBuilder.create()
        Log.i(TAG, "testBuilderDesignMode DailyReportBuilder :\n ${dailyReport.buildReport()}")

        val monthReportBuilder = MonthReportBuilder()
        Director(monthReportBuilder).construct("2020-8-2", "学习设计模式！")
        val monthReport = monthReportBuilder.create()
        Log.i(TAG, "testBuilderDesignMode MonthReportBuilder :\n ${monthReport.buildReport()}")

        //Buider模式  链式调用
        val reportLink = ReportLink.Builder()
            .builderTile("开发日志")
            .builderContent("2020-8-8 学习了建造者的链式调用，学习进度延迟！")
            .builderDay("2020-8-8")
            .builderNextPlan("接下来学习原型模式")
//            .buildersubmitDate("2020-8-8") //这里可以设置也可以不设置，内部有默认的，这是Builder模式的优点
            .builderPerson("Brian")
            .create()


        Log.i(
            TAG,
            "testBuilderDesignMode  reportLink:\n ${reportLink.anyToString()} "
        )


    }

    private fun testSingletonDesignMode() {
        //饿汉
        SingletonHungry.getInstance().init()
        SingletonHungryKotlin.init()
        Log.i(TAG, "SingletonHungry value:${SingletonHungry.getInstance().name}")
        Log.i(TAG, "SingletonHungryKotlin value:${SingletonHungryKotlin.name}")
        //懒汉
        SingletonLazy.getInstance().init()
        SingletonLazyKotlin.instance!!.init()
        Log.i(TAG, "SingletonLazy value:${SingletonLazy.getInstance().name}")
        Log.i(TAG, "SingletonLazyKotlin value:${SingletonLazyKotlin.instance!!.name}")

        SingletonDCL.getInstance().init()
        SingletonDCLKotlin.instance!!.init()
        Log.i(TAG, "SingletonDCL value:${SingletonDCL.getInstance().name}")
        Log.i(TAG, "SingletonDCLKotlin value:${SingletonDCLKotlin.instance!!.name}")

        SingletonInner.getInstance().init()
        SingletonInnerKotlin.instance!!.init()
        Log.i(TAG, "SingletonInner value:${SingletonInner.getInstance().name}")
        Log.i(TAG, "SingletonInnerKotlin value:${SingletonInnerKotlin.instance!!.name}")

        SingletonEnum.INSTANCE.init()
        SingletonEnumKotlin.INSTANCE!!.init()
        Log.i(TAG, "SingletonEnum value:${SingletonEnum.INSTANCE.name2}")
        Log.i(TAG, "SingletonEnumKotlin value:${SingletonEnumKotlin.INSTANCE!!.name2}")


    }
}