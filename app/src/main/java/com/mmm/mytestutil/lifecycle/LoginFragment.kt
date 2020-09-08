package com.mmm.mytestutil.lifecycle

import android.content.Context
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.mmm.mytestutil.R

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
    private val TAG ="Login fragment -->"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e(TAG , "onAttach called !")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG , "onCreate called !")
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