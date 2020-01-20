package com.mmm.mytestutil.drawerLayout

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.annotation.RequiresApi
import com.githang.statusbar.StatusBarCompat
import com.mmm.mytestutil.R
import kotlinx.android.synthetic.main.activity_drawer.*
/*
 * 抽屉布局
 */
class DrawerActivity : AppCompatActivity(), View.OnClickListener {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        //设置沉浸式状态栏
        StatusBarCompat.setStatusBarColor(this, getColor(R.color.color1), true)
        btnLeft.setOnClickListener(this)
    }

    @SuppressLint("WrongConstant")
    override fun onClick(v: View?) {
        when (v){
            btnLeft -> dlLeft.openDrawer(Gravity.START , true)
        }
    }
}
