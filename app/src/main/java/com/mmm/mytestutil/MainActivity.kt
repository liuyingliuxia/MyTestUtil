package com.mmm.mytestutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mmm.mytestutil.glide.GlideActivity
import com.mmm.mytestutil.vp2.Vp2TestActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvVp2.setOnClickListener(this)
        tvGlide.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            tvVp2 -> myUtil.jumpView(this,Vp2TestActivity())
            tvGlide -> myUtil.jumpView(this,GlideActivity())
        }
    }
}
