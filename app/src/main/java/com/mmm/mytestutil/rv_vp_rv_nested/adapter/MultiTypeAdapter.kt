package com.gaohui.nestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gaohui.nestedrecyclerview.holder.SimpleTextViewHolder
import com.mmm.mytestutil.R
import com.mmm.mytestutil.rv_vp_rv_nested.ChildRecyclerView
import com.mmm.mytestutil.rv_vp_rv_nested.holder.SimpleCategoryViewHolder

class MultiTypeAdapter(private val dataSet:ArrayList<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val  TYPE_TEXT = 0
        private const val TYPE_CATEGORY = 1
    }

    private var mCategoryViewHolder: SimpleCategoryViewHolder? = null

    override fun getItemViewType(position: Int): Int {
        return if(dataSet[position] is String) {
            TYPE_TEXT
        } else {
            TYPE_CATEGORY
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == TYPE_TEXT) {
            SimpleTextViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_item_text,viewGroup,false))
        } else {
            val categoryViewHolder = SimpleCategoryViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_item_category,viewGroup,false))
            mCategoryViewHolder =  categoryViewHolder
            return categoryViewHolder
        }
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, pos: Int) {
        if(holder is SimpleTextViewHolder) {
            holder.mTv.text = dataSet[pos] as String
        } else if(holder is SimpleCategoryViewHolder){
            holder.bindData(dataSet[pos])
        }
    }

    fun getCurrentChildRecyclerView(): ChildRecyclerView? {
        mCategoryViewHolder?.apply {
           return this.getCurrentChildRecyclerView()
        }
        return null
    }


}