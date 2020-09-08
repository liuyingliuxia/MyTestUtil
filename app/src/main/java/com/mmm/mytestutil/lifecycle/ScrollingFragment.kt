package com.mmm.mytestutil.lifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mmm.mytestutil.R

class ScrollingFragment : Fragment() {
    val TAG ="scrolling fragment ->"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e(TAG , "onAttach called !")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG , "onCreate called !")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.e(TAG , "onCreateView called !")
        return inflater.inflate(R.layout.fragment_scrolling, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e(TAG , "onActivityCreated called !")
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG , "onStart called !")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG , "onResume called !")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG , "onPause called !")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG , "onStop called !")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(TAG , "onDestroyView called !")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG , "onDestroy called !")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e(TAG , "onDetach called !")
    }
}