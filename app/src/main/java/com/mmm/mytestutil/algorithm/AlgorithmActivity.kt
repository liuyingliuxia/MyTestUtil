package com.mmm.mytestutil.algorithm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.mmm.mytestutil.R
import com.mmm.mytestutil.myUtil
import kotlinx.android.synthetic.main.activity_algorithm.*


class AlgorithmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_algorithm)
        tvBubble.setOnClickListener(click)
        tvChoose.setOnClickListener(click)
        tvBucket.setOnClickListener(click)
        Intent()
    }

    private val click = View.OnClickListener {
        when(it){
            tvBubble -> gifBubble.isVisible = true
            //tvChoose -> gifBubble
            tvBucket -> myUtil.jumpView(this , BucketActivity())
        }
    }
}