package com.mmm.mytestutil

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.githang.statusbar.StatusBarCompat
import com.mmm.mytestutil.drawerLayout.DrawerActivity
import com.mmm.mytestutil.glide.GlideActivity
import com.mmm.mytestutil.twoRecycler.TwoRecyclerActivity
import com.mmm.mytestutil.vp2.Vp2TestActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //设置沉浸式状态栏
        StatusBarCompat.setStatusBarColor(this, getColor(R.color.color1), true)

        tvVp2.setOnClickListener(this)
        tvGlide.setOnClickListener(this)
        tvBaseQuick.setOnClickListener(this)
        tvDrawer.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            tvVp2 -> myUtil.jumpView(this,Vp2TestActivity())
            tvGlide -> myUtil.jumpView(this,GlideActivity())
            tvBaseQuick -> myUtil.jumpView(this , TwoRecyclerActivity())
            tvDrawer -> myUtil.jumpView(this , DrawerActivity())
        }
    }
}
