package com.mmm.mytestutil.algorithm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.mmm.mytestutil.R
import kotlinx.android.synthetic.main.activity_algorithm.*

class AlgorithmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_algorithm)
        tvBubble.setOnClickListener(click)
    }

    private val click = View.OnClickListener {
        when(it){
            tvBubble -> gifBubble.isVisible = true
        }
    }
}