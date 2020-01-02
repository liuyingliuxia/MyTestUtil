package com.mmm.mytestutil.glide

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.mmm.mytestutil.R
import kotlinx.android.synthetic.main.activity_glide.*

class GlideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)
        Glide.with(this).load("http://f.hiphotos.baidu.com/zhidao/pic/item/8ad4b31c8701a18bcab7e37a9d2f07082838fea3.jpg").into(ivImage1)
        Glide.with(this).load(R.drawable.fruit_10).into(ivImage2)
    }

/*    fun getView(position: Int, recycled: View?, container: ViewGroup?): View {
        val myImageView: ImageView
        myImageView = if (recycled == null) {
            inflater.inflate(R.layout.my_image_view, container, false) as ImageView
        } else {
            recycled as ImageView
        }
        val url: String = myUrls.get(position)
        Glide
            .with(myFragment)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.loading_spinner)
            .crossFade()
            .into(myImageView)
        return myImageView
    }*/
}