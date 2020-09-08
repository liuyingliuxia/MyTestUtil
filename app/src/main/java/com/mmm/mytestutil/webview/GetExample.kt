package com.mmm.mytestutil.webview

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.util.*

class GetExample {
    var client = OkHttpClient()

    @Throws(IOException::class)
    fun run(): String {
        val request = Request.Builder()
            .url("https://raw.github.com/square/okhttp/master/README.md")
            .build()
        client.newCall(request).execute()
            .use { response -> return Objects.requireNonNull(response.body)!!.string() }
    }

    companion object {
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val example = GetExample()
            val response = example.run()
            println(response)
        }
    }
}