package com.mmm.mytestutil.okhttp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import okhttp3.RequestBody.Companion.toRequestBody
import com.mmm.mytestutil.R
import kotlinx.android.synthetic.main.activity_ok_http.*
import okhttp3.*
import org.jetbrains.anko.makeCall
import java.io.IOException


class OkHttpActivity : AppCompatActivity() {
    var result = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ok_http)
        test()

    }

    fun test() {
        val urlAPI: String = "https://www.abc.com/api/test"

        val builder = FormBody.Builder()
        builder.add("username", "彭裤子")
        val formBody = builder.build()

        val request = Request.Builder()
            .method("POST", formBody)
            .url(urlAPI).build()


        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response) {
                result = response.body!!.string()

                Log.e("TAG" , "result：$result")
               // tvResult.text = result
            }

            override fun onFailure(call: Call, e: IOException) {
                Log.e("TAG" , "Failed request api :( " + e.message)
            }

        })
    }
}
