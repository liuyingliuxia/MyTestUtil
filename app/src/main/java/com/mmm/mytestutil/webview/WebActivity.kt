package com.mmm.mytestutil.webview

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.mmm.mytestutil.R
import kotlinx.android.synthetic.main.activity_web.*
import org.jetbrains.anko.webView

class WebActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        wvWeb.settings.javaScriptEnabled = true
        wvWeb.webViewClient
        wvWeb.loadUrl("https://www.baidu.com")
    }
}