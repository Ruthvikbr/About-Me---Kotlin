package com.diceroller.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.diceroller.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName:MyName = MyName("Ruthvik B.R")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName = myName

        binding.Done.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view:View){
        binding.apply {
            //binding.nickNameTv.text = binding.nickname.text
            myName?.nickName = nickname.text.toString()
            invalidateAll()
            binding.Done.visibility = View.GONE
            binding.nickname.visibility = View.GONE
            binding.nickNameTv.visibility = View.VISIBLE
        }
        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
