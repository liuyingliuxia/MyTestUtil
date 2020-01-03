package com.mmm.mytestutil.twoRecycler

import android.widget.RelativeLayout
import android.widget.TextView
import com.example.lilingzhi.tworecyc.bean.OneBean
import com.mmm.mytestutil.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class OneAdapter(var layoutId:Int,var datas:List<OneBean>):BaseQuickAdapter<OneBean,BaseViewHolder>(layoutId,datas){

    var index=-1;

    override fun convert(helper: BaseViewHolder?, item: OneBean?) {

        helper!!.getView<TextView>(R.id.tv).setText(item!!.name)

        if(index==item.id){
            helper.getView<RelativeLayout>(R.id.rl).setBackgroundColor(mContext.resources.getColor(R.color.color7))
        }else{
            helper.getView<RelativeLayout>(R.id.rl).setBackgroundColor(mContext.resources.getColor(R.color.color1))
        }
    }




}