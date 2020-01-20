package com.mmm.mytestutil.rv_rv_nested

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mmm.mytestutil.R
import kotlinx.android.synthetic.main.item_rv.view.*

//分类页面 右侧内容，使用vp2

class vp2Adapter (var context: Context, var list: List<RecyclerView>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    //    private lateinit var gridLM : GridLayoutManager
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_rv, parent, false)
        val holder = Holder(itemView)
        return holder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val h = holder.itemView
        val head = headImgBean(mSortHeadTag[position], mContentHeadImg[position])

        val rvAdapter = rvAdapter(head, addAllItem(position), context)
        val layoutManager = GridLayoutManager(context, 3)
        //设置根据类型不同，横跨不同列
        val spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position == 0) 3 else 1
            }
        }
        layoutManager.spanSizeLookup = spanSizeLookup

        layoutManager.orientation = GridLayoutManager.VERTICAL

        h.rvRv.layoutManager = layoutManager
        h.rvRv.adapter = rvAdapter

        h.rvRv.setOnTouchListener { v, event ->
            when (event.action) {
                //当用户按下的时候，我们告诉父组件，不要拦截我的事件（这个时候子组件是可以正常响应事件的），拿起之后就会告诉父组件可以阻止。
                MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> v.parent.requestDisallowInterceptTouchEvent(
                    true
                )
                MotionEvent.ACTION_UP -> v.parent.requestDisallowInterceptTouchEvent(false)
            }
            false
        }

        //还需判断内部rv滑倒底部时 才能翻页
        h.rvRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                //切断子母列表循环联调
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //判断当前子列表显示哪个id的内容
                }
            }
        })
    }

    fun addAllItem(position: Int): ArrayList<itemBean> {
        val itemList: ArrayList<itemBean> = arrayListOf()
        //第一个空的itemBean用来放第一张的大图
       // itemList.add(itemBean(0,0,""))
        when (position) {
            0 -> {
                itemList.clear()
                for (i in 0 until 13 /* mSortNum[position]*/) {
                    val iBean = itemBean(i, mCatalog1[i], mCatalogName1[i])
                    itemList.add(iBean)
                }
            }
            1 -> {
                itemList.clear()
                for (i in 0 until 14 /*mSortNum[position]*/) {
                    val iBean = itemBean(i, mCatalog2[i], mCatalogName2[i])
                    itemList.add(iBean)
                }

            }
            2 -> {
                itemList.clear()
                for (i in 0 until 18 /* mSortNum[position]*/) {
                    val iBean = itemBean(i, mCatalog3[i], mCatalogName3[i])
                    itemList.add(iBean)
                }

                Log.e("每一页的全部item", itemList.toString())
            }
        }
        return itemList
    }
}

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)