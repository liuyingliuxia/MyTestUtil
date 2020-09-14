package com.mmm.mytestutil.algorithm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.load.engine.bitmap_recycle.IntegerArrayAdapter
import com.mmm.mytestutil.R
import kotlinx.android.synthetic.main.activity_algorithm.*
import kotlinx.android.synthetic.main.activity_bucket.*

/**
 * author : Miracle.lin
 * time   : 2020/09/11
 * desc   :
 * e-mail : miracle.lin@zeasn.com
 */
class BucketActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bucket)
        var input = etNum.text.toString()

    }
}