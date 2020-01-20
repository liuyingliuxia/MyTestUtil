package com.mmm.mytestutil.rv_rv_nested

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.mmm.mytestutil.R
import kotlinx.android.synthetic.main.activity_rv_in_rv.*

/*
 * 滑动嵌套 两层 自己写的 关键是
 */
class RvInRvActivity : AppCompatActivity() {
    private lateinit var vp2Adapter: vp2Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_in_rv)
        val rvList :ArrayList<RecyclerView> = arrayListOf()
        val rvView :RecyclerView = RecyclerView(this)
        for (i in  0.. 2) {
            rvList.add(rvView)
        }
        vp2Adapter = vp2Adapter(this , rvList)
        vp2.adapter = vp2Adapter


    }
}