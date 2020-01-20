package com.mmm.mytestutil.eventbus

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mmm.mytestutil.R
import kotlinx.android.synthetic.main.activity_event_bus_demo.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class EventBusDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_bus_demo)
        EventBus.getDefault().register(this)
    }

    @SuppressLint("SetTextI18n")
    @Subscribe(sticky = true) // 粘性事件 可接受
    fun onStickyEvent(event: MessageEvent) {
        tvReceiver!!.text = "${tvReceiver.text} : ${ event.message} "
    }

    @SuppressLint("SetTextI18n")
    @Subscribe(sticky = true) // 非粘性事件 更新界面 在主线程 接收不到 其他组件的
    fun onEvent(event: MessageEvent) {
        Log.e("post","接收到了 post")
        tvReceiver2!!.text = "${tvReceiver2.text} : ${ event.message} 代码 ： ${event.code }"
    }


    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
}
