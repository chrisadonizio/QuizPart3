package com.adonizio.honorsmobileapps.Quiz_Fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.adonizio.honorsmobileapps.Quiz_Fragments.databinding.ActivityMainBinding
const val KEY_INDEX = "index_of_question_key"
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)

    }

}