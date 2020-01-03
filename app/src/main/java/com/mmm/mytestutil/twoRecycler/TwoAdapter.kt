package com.mmm.mytestutil.twoRecycler

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.lilingzhi.tworecyc.bean.OneBean
import com.example.lilingzhi.tworecyc.bean.TwoBean
import com.mmm.mytestutil.R

class TwoAdapter(var layoutId:Int,var datas:List<TwoBean>):BaseQuickAdapter<TwoBean,BaseViewHolder>(layoutId,datas){





    override fun convert(helper: BaseViewHolder?, item: TwoBean?) {

        helper!!.getView<TextView>(R.id.tv).setText(item!!.name)
    }
}