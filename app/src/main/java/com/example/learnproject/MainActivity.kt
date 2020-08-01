package com.example.learnproject

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.learnproject.designmode.*
import com.example.learnproject.ui.main.SectionsPagerAdapter

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
        }


        testDesignMode()

    }

    private fun testDesignMode() {
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