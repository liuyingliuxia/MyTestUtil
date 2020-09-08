package com.mmm.mytestutil.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.mmm.mytestutil.R
import kotlinx.android.synthetic.main.activity_life_cycle.*

class LifeCycleActivity : AppCompatActivity() {
    val TAG ="this activity:"

    private inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        beginTransaction().func().commit()
    }

    private fun FragmentActivity.addFragment(fragment: Fragment, frameId: Int){
        supportFragmentManager.inTransaction { add(frameId, fragment) }
    }


    private fun FragmentActivity.replaceFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.inTransaction{replace(frameId, fragment)}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        Log.e(TAG , "onCreate called 创建")
        tvLogin.setOnClickListener {
            replaceFragment(LoginFragment(), R.id.flContainer)
        }

        tvScrolling.setOnClickListener {
            replaceFragment(ScrollingFragment() , R.id.flContainer )
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG , "onCreate called 开始")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG , "onRestart called 重新开始")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG , "onResume called 恢复")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG , "onPause called 暂停")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG , "onStop called 停止")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG , "onDestroy called 销毁")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        val param= savedInstanceState.getInt("param")
        Log.e(TAG , "onRestoreInstanceState called.get param:$param")
        super.onRestoreInstanceState(savedInstanceState)

    }
}