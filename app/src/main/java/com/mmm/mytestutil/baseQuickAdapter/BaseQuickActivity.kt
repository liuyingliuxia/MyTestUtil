package com.mmm.mytestutil.baseQuickAdapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mmm.mytestutil.R
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import com.githang.statusbar.StatusBarCompat
import kotlinx.android.synthetic.main.activity_base_quick.*

class BaseQuickActivity : AppCompatActivity() {
    //quick适配器
//    private lateinit var quickLeftAdapter: QuickLeftAdapter
//    private lateinit var quickRightAdapter: QuickRightAdapter

    //quick用的布局管理器
    private lateinit var leftLayoutManager: LinearLayoutManager
    private lateinit var rightLayoutManager: LinearLayoutManager

    //数据实体
    var leftData: MutableList<LeftBean> = mutableListOf()
    var rightData: MutableList<RightBean> = mutableListOf()

    var rightClick: Boolean = false
    lateinit var handler: Handler

    //分割线
    lateinit var leftItemD : DividerItemDecoration
    lateinit var rightItemD :DividerItemDecoration

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_quick)
        //设置沉浸式状态栏
        StatusBarCompat.setStatusBarColor(this, getColor(R.color.color1), true)
        //initData()
       // initView()
        //一次只能滑动一页，不能快速滑动
         val pagerSnapHelper = PagerSnapHelper()
         pagerSnapHelper.attachToRecyclerView(rvRight)
    }

/*    fun initData() {
        handler = Handler()
        val leftBean = LeftBean(0, "", 1)

        for (i in 0..mCatalogText.size) {
            //更具itemType不同添加不同的数据
            if (i < mCatalogText.size) {
                leftBean.type = LeftBean.TYPE_TEXT
                leftData.add(LeftBean(i, mCatalogText[i], 1))
                //    rightData.add(RightBean(i, mContentHeadImg[i], mAllItemImg1[i], mAllName1[i] ,mSortNum[i] ))
            } else if (i == mCatalogText.size) {
                leftBean.type = LeftBean.TYPE_EMPTY
                leftData.add(LeftBean((mCatalogText.size), "", 2))
            }
        }

        Log.e("left", leftData.toString())
    }

    fun initView() {
        leftLayoutManager = LinearLayoutManager(context)
        leftLayoutManager.orientation = LinearLayoutManager.VERTICAL

        rightLayoutManager = LinearLayoutManager(context)
        rightLayoutManager.orientation = LinearLayoutManager.VERTICAL

        rvLeft.layoutManager = leftLayoutManager
        // rvRight.layoutManager = rightLayoutManager

        //分割线
        *//*    leftItemD = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        rightItemD = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        rvLeft.addItemDecoration(leftItemD)
        rvRight.addItemDecoration(rightItemD)*//*

        quickLeftAdapter = QuickLeftAdapter(leftData)
        //  quickRightAdapter = QuickRightAdapter(R.layout.item_sort_right, rightData)

        rvLeft.adapter = quickLeftAdapter
        //  rvRight.adapter = quickRightAdapter

        quickLeftAdapter.setOnItemClickListener { _, _, position ->
            rightClick = true
            //  select(position)

            var rightI = 0
            while (rightI < rightData.size) {
                if (rightData.get(rightI).id == leftData.get(position).id) {
                    break;
                }
                rightI++
            }

            // RecycUtil.moveToPositAndTop(rightI, rightLayoutManager, rvRight, handler)

        }
        //滑动时，左侧导航栏同步改变选中状态
        // rvRight.addOnScrollListener(object : RecyclerView.OnScrollListener() {


            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {

                //使用quickBase适配器写法
                if (rightClick == false && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val now: Int
                    val first = rightLayoutManager.findFirstVisibleItemPosition()
                    if (rightData.get(first).isTitle) {
                        now = rightData.get(first).id
                    } else {
                        if (rightData.get(first).id + 1 > leftData.get(leftData.size - 1).id) {
                            now = rightData.get(first).id
                        } else {
                            now = rightData.get(first).id + 1
                        }
                    }
                    //滑动右侧列表时 ：
                    RecycUtil.moveToPositAndCenter(now, leftLayoutManager, rvLeft, handler)
                    select(now)
                } else if (rightClick == true && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    rightClick = false
                } else if (rightClick == true && newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                    rightClick = false
                }
            }

        })
    }

    fun select(position: Int) {
        val i = quickLeftAdapter.index
        quickLeftAdapter.index = position
        if (i >= 0) {
            quickLeftAdapter.notifyItemChanged(i)
        }
        quickLeftAdapter.notifyItemChanged(position)
    }

    }*/
}

