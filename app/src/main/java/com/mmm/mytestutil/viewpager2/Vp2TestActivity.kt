package com.mmm.mytestutil.viewpager2

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.githang.statusbar.StatusBarCompat
import com.mmm.mytestutil.R
import java.util.*
/*
 * 别人写的   VP2 小例子
 */
class Vp2TestActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vp2_test)
        //设置沉浸式状态栏
        StatusBarCompat.setStatusBarColor(this, getColor(R.color.color1), true)
        var mViewPager2 = findViewById<ViewPager2>(R.id.viewpager2)
        val list: MutableList<String> = ArrayList()
        list.add("页面一")
        list.add("页面二")
        list.add("页面三")
        list.add("页面四")
        mViewPager2.setAdapter(ViewPagerAdapter(this, list, mViewPager2))
    }
}