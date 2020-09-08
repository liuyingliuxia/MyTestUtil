package com.mmm.mytestutil.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mmm.mytestutil.R
import com.mmm.mytestutil.SimpleHttpUtils
import kotlinx.android.synthetic.main.activity_web_u_r_l.*
import kotlinx.coroutines.*
import org.jetbrains.anko.indeterminateProgressDialog
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

/*class WebURLActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_u_r_l)
        tvResponse.setOnClickListener(send)
    }

    private val send = View.OnClickListener {
        if (it == tvResponse)
            sendRequestWithHttpURLConnection()
    }

    private fun sendRequestWithHttpURLConnection() {
        object : Thread() {
            override fun run() {
                var connection: HttpURLConnection? =null
                var reader: BufferedReader? = null
                try {
                    var url: URL = URL ("http://www.baidu.com")
                    val connection = url.openConnection() as HttpURLConnection
                    connection.let {
                        it.requestMethod = "GET"
                        it.connectTimeout = 8000
                        it.readTimeout = 8000
                        it.doInput = true
                        it.doOutput = true
                        it.useCaches = false
                        it.instanceFollowRedirects = true

                    }
                    val inputStream :InputStream = connection.inputStream
                    reader = BufferedReader(InputStreamReader(inputStream  )  )
                    var response = StringBuilder()
                    var line = reader.readLine()
                    if(line.isNotEmpty())
                        response.append(line)
                    showResponse(response.toString())
                } catch (e :Exception) {
                    e.printStackTrace()
                }finally {
                    reader?.close()
                    connection?.disconnect()
                }

            }
        }.start()
    }

    private fun showResponse(response :String ){
       runOnUiThread {
           run {
               tvResponse.text = response
           }
       }
    }
}*/
class WebURLActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_u_r_l)
        btnGetRequest.setOnClickListener { onGetRequest() }
        btnPostRequest.setOnClickListener { onPostRequest() }
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }

    /**
     * Get请求
     */
    private fun onGetRequest() = launch {
        val dlg = indeterminateProgressDialog("loading...")
        // 接名地址
        val url = "http://v.juhe.cn/weather/index"
        // 接口参数
        val mapParam = mapOf(
            "format" to "1",
            "cityname" to "上海",
            "key" to "3bc829216bb4ede1e846fe91b3df5543"
        )
        // 挂起当前的协程并运行自定义的get方法，方法返回后再恢复协程
        val result = withContext(Dispatchers.IO) {
            SimpleHttpUtils.get(url, mapParam) // 发起GET请求
        }
        tvResponse.text = result
        dlg.dismiss()
    }

    /**
     * Post请求
     */
    private fun onPostRequest() = launch {
        val dlg = indeterminateProgressDialog("loading...")
        // 接名地址
        val url = "https://www.pgyer.com/apiv2/app/check"
        // 接名参数
        val mapParam = mapOf(
            "_api_key" to "38bb2810d62311dcfa573930b367c180",
            "appKey" to "b6e389f007a01631e7024c6908846e62"
        )
        // 挂起当前的协程并运行自定义的post方法，方法返回后再恢复协程
        val result = withContext(Dispatchers.IO) {
            SimpleHttpUtils.post(url, mapParam) // 发起POST请求
        }
        tvResponse.text = result
        dlg.dismiss()
    }
}