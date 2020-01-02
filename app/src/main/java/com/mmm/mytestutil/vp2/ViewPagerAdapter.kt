package com.mmm.mytestutil.vp2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.mmm.mytestutil.R

/**
 * @Author: wuchaowen
 * @Description:
 * @Time:
 */
class ViewPagerAdapter(context: Context?, data: List<String>, viewPager2: ViewPager2) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {
    private val mData: List<String>
    private val mInflater: LayoutInflater
    private val viewPager2: ViewPager2
    private val colorArray = intArrayOf(android.R.color.black, android.R.color.holo_blue_dark, android.R.color.holo_green_dark, android.R.color.holo_red_dark)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.vp2_item_test, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = mData[position]
        holder.myTextView.text = animal
        holder.relativeLayout.setBackgroundResource(colorArray[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var myTextView: TextView
        var relativeLayout: RelativeLayout

        init {
            myTextView = itemView.findViewById(R.id.tvTitle)
            relativeLayout = itemView.findViewById(R.id.container)
        }
    }

    init {
        mInflater = LayoutInflater.from(context)
        mData = data
        this.viewPager2 = viewPager2
    }
}