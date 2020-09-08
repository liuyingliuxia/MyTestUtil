package com.mmm.mytestutil

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.githang.statusbar.StatusBarCompat
import com.mmm.mytestutil.algorithm.AlgorithmActivity
import com.mmm.mytestutil.coroutlines_retrofit.RetrofitActivity
import com.mmm.mytestutil.drawerLayout.DrawerActivity
import com.mmm.mytestutil.eventbus.EventBusDemoActivity
import com.mmm.mytestutil.eventbus.MessageEvent
import com.mmm.mytestutil.glide.GlideActivity
import com.mmm.mytestutil.lifecycle.LifeCycleActivity
import com.mmm.mytestutil.music_play.MusicActivity
import com.mmm.mytestutil.okhttp.OkHttpActivity
import com.mmm.mytestutil.rv_vp_rv_nested.NestedRecyclerActivity
import com.mmm.mytestutil.rv_rv_nested.RvInRvActivity
import com.mmm.mytestutil.two_rv_link.TwoRecyclerActivity
import com.mmm.mytestutil.viewpager2.Vp2TestActivity
import com.mmm.mytestutil.webview.JWebActivity
import com.mmm.mytestutil.webview.WebActivity
import com.mmm.mytestutil.webview.WebURLActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.drawer_top.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //设置沉浸式状态栏
        StatusBarCompat.setStatusBarColor(this, getColor(R.color.color1), true)

        tvVp2.setOnClickListener(click)
        tvGlide.setOnClickListener(click)
        tvBaseQuick.setOnClickListener(click)
        tvDrawer.setOnClickListener(click)
        tvNestedRecycler.setOnClickListener(click)
        tvRvInRecycler.setOnClickListener(click)
        tvEventBus.setOnClickListener(click)
        tvMusicPlay.setOnClickListener(click)
        tvRetrofit.setOnClickListener (click)
        tvWeb.setOnClickListener(click)
        tvSendQuest.setOnClickListener(click)
        tvLifeCycle.setOnClickListener(click)
        tvOkhttp.setOnClickListener(click)
        tvAlgorithm.setOnClickListener(click)
    }

    private val click = View.OnClickListener {
        when (it) {
            tvVp2 -> myUtil.jumpView(this, Vp2TestActivity())
            tvGlide -> myUtil.jumpView(this, GlideActivity())
            tvBaseQuick -> myUtil.jumpView(this, TwoRecyclerActivity())
            tvDrawer -> myUtil.jumpView(this, DrawerActivity())
            tvNestedRecycler -> myUtil.jumpView(this, NestedRecyclerActivity())
            tvRvInRecycler -> myUtil.jumpView(this, RvInRvActivity())
            tvEventBus -> { // 粘性 postSticky 非 post
                EventBus.getDefault().postSticky(MessageEvent(0, "new mesage 1"))// 粘性发送成功 其他 activity 要用粘性 的
               // EventBus.getDefault().post(MessageEvent(1, "new mesage 2"))
                  myUtil.jumpView(this, EventBusDemoActivity())

            }
            tvMusicPlay ->  myUtil.jumpView(this, MusicActivity())
            tvRetrofit -> myUtil.jumpView(this ,RetrofitActivity())
            tvWeb -> myUtil.jumpView(this,WebActivity())
            tvSendQuest -> myUtil.jumpView(this , JWebActivity())
            tvLifeCycle -> myUtil.jumpView(this , LifeCycleActivity())
            tvOkhttp -> myUtil.jumpView(this , OkHttpActivity())
            tvAlgorithm ->myUtil.jumpView(this , AlgorithmActivity())
        }
    }

    /** EventBus------------**/
    @Subscribe(sticky = true )
    fun onMessageEvent(messageEvent: MessageEvent) {
        tvEventBus!!.text = messageEvent.message
    }


    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }
    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
}

