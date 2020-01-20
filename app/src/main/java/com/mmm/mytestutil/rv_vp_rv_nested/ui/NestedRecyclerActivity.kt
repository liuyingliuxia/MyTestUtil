package com.mmm.mytestutil.rv_vp_rv_nested

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.gaohui.nestedrecyclerview.adapter.MultiTypeAdapter
import com.githang.statusbar.StatusBarCompat
import com.mmm.mytestutil.R
import com.mmm.mytestutil.rv_vp_rv_nested.bean.CategoryBean
import kotlinx.android.synthetic.main.activity_nested_recycler.*
import java.util.*
/*
 *  别人写的  三重嵌套的冲突解决
 */

class NestedRecyclerActivity : AppCompatActivity() {

    private val mDataList = ArrayList<Any>()

    private val strArray = arrayOf("关注", "推荐", "视频", "直播", "图片", "段子", "精华", "热门")
//    private val strArray = arrayOf("关注")

    var lastBackPressedTime = 0L

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_recycler)
        //设置沉浸式状态栏
        StatusBarCompat.setStatusBarColor(this, getColor(R.color.color1), true)

        parentRecyclerView.initLayoutManager()

        initData()
    }

    private fun initData() {
        val multiTypeAdapter = MultiTypeAdapter(mDataList)
        for (i in 0..8) {
            mDataList.add("parent item text $i")
        }
        val categoryBean = CategoryBean()
        categoryBean.tabTitleList.clear()
        categoryBean.tabTitleList.addAll(strArray.asList())
        mDataList.add(categoryBean)
        parentRecyclerView.adapter = multiTypeAdapter
        multiTypeAdapter.notifyDataSetChanged()
    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - lastBackPressedTime < 2000) {
            super.onBackPressed()
        } else {
            parentRecyclerView.scrollToPosition(0)
            Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_SHORT).show()
            lastBackPressedTime = System.currentTimeMillis()
        }
    }
}
