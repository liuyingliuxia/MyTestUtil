package com.mmm.mytestutil.coroutlines_retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.load.HttpException
import com.mmm.mytestutil.R
import com.mmm.mytestutil.myUtil.Companion.talk
import kotlinx.android.synthetic.main.activity_retrofit.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RetrofitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val service = RetrofitFactory.makeRetrofitService()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getPosts()
            try {
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        response.body()?.let { initRecyclerView(it) }
                    } else {
                        talk(this@RetrofitActivity ,"Error network operation failed with ${response.code()}")
                    }
                }
            } catch (e: HttpException) {
                Log.e("REQUEST", "Exception ${e.message}")
            } catch (e: Throwable) {
                Log.e("REQUEST", "Ooops: Something else went wrong")
            }
        }
    }

    private fun initRecyclerView(list: List<Post>) {
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = PostAdapter(list, this)
    }
}
