package com.mmm.mytestutil.two_rv_link

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.lilingzhi.tworecyc.bean.OneBean
import com.example.lilingzhi.tworecyc.bean.TwoBean
import com.mmm.mytestutil.R

import kotlinx.android.synthetic.main.activity_two_recycler.*

/*
 * 别人写的 双表联动 使用 BQA
 */
class TwoRecyclerActivity : AppCompatActivity() {


    lateinit var oneLayoutM: LinearLayoutManager
    lateinit var twoLayoutM: LinearLayoutManager

    lateinit var oneAdapter: OneAdapter
    lateinit var twoAdapter: TwoAdapter

    lateinit var oneitemD: DividerItemDecoration
    lateinit var twoitemD:DividerItemDecoration

    var oneData:MutableList<OneBean> = mutableListOf()
    var twoData:MutableList<TwoBean> = mutableListOf()

    lateinit var handler:Handler
    var rightClick:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_recycler)

        initData()

        initView()
        //一次只能滑动一页，不能快速滑动
        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(rvTwo)


    }

    fun initData(){


        handler= Handler()

        var i=0
        var j :Int
        while (i<20){
            oneData.add(OneBean(i,"标题："+i))
            j=0
            twoData.add(TwoBean(i,"标题："+i,true))
            while (j<5){
                twoData.add(TwoBean(i,"内容:"+j,false))
                j++
            }
            i++

        }
    }


    fun initView(){
        oneLayoutM=LinearLayoutManager(this)
        oneLayoutM.orientation=LinearLayoutManager.VERTICAL

        twoLayoutM=LinearLayoutManager(this)
        oneLayoutM.orientation=LinearLayoutManager.VERTICAL

        rvOne.layoutManager=oneLayoutM
        rvTwo.layoutManager=twoLayoutM
        //添加分割线
        oneitemD= DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        twoitemD= DividerItemDecoration(this,DividerItemDecoration.VERTICAL)

        rvOne.addItemDecoration(oneitemD)
        rvTwo.addItemDecoration(twoitemD)

        oneAdapter=OneAdapter(R.layout.item_one,oneData)
        twoAdapter=TwoAdapter(R.layout.item_two,twoData)
        rvOne.adapter=oneAdapter
        rvTwo.adapter=twoAdapter


        oneAdapter.setOnItemClickListener { adapter, view, position ->

            rightClick=true
            //点击变色
            select(position)
            //点击右侧滚动
            //判断右侧滚动到哪里
            var twoI=0
            while (twoI<twoData.size){
                if(twoData.get(twoI).id==oneData.get(position).id){
                    break;
                }
                twoI++
            }

            RecycUtil.moveToPositAndTop(twoI,twoLayoutM,rvTwo,handler)
        }


       rvTwo.addOnScrollListener(object : RecyclerView.OnScrollListener(){
           override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
               //切断子母列表循环联调
               if(rightClick==false&& newState == RecyclerView.SCROLL_STATE_IDLE){
                   //判断当前子列表显示哪个id的内容
                   var now:Int
                   val first= twoLayoutM.findFirstVisibleItemPosition()
                   if(twoData.get(first).isTitle){
                       now=twoData.get(first).id
                   }else{
                       if(twoData.get(first).id+1>oneData.get(oneData.size-1).id){
                           now=twoData.get(first).id
                       }else{
                           now=twoData.get(first).id+1
                       }
                   }
                   //滚动主列表

                   RecycUtil.moveToPositAndCenter(now,oneLayoutM,rvOne,handler)
                   select(now)

               }else if(rightClick==true&& newState == RecyclerView.SCROLL_STATE_IDLE){
                   rightClick=false
               }else if(rightClick==true&&newState == RecyclerView.SCROLL_STATE_DRAGGING){
                   rightClick=false
               }
           }
       })
    }

    fun select(position:Int){
        val i=oneAdapter.index
        oneAdapter.index=position
        if(i>=0){
            oneAdapter.notifyItemChanged(i)
        }
        oneAdapter.notifyItemChanged(position)
        Log.v("zzww"," i:"+i+" position:"+position)
    }
}
