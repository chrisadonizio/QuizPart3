package com.adonizio.honorsmobileapps.Quiz_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.adonizio.honorsmobileapps.Quiz_Fragments.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    data class Question(val id:Int, val answer:Boolean)
    val questions = listOf(Question(R.string.question1,true),Question(R.string.question2,false),Question(R.string.question3,true),Question(R.string.question4,true), Question(R.string.question5,false))
    var indexOfQuestion = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        val rootView = binding.root
        if(savedInstanceState!=null){
            indexOfQuestion = savedInstanceState.getInt(KEY_INDEX)
        }
        updateQuestionText()
        binding.trueButton.setOnClickListener{
            checkAnswer(true)
        }
        binding.FalseButton.setOnClickListener{
            checkAnswer(false)
        }
        binding.nextButton.setOnClickListener{
            nextQuestion()
        }
        binding.QuestionTextView.setOnClickListener{
            nextQuestion()
        }
        binding.back.setOnClickListener{
            previousQuestion()
        }
        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle){
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt(KEY_INDEX, indexOfQuestion)
    }
    fun nextQuestion(){
        indexOfQuestion+=1
        indexOfQuestion = indexOfQuestion% questions.size
        updateQuestionText()
    }
    fun previousQuestion(){
        if(indexOfQuestion-1>=0) {
            indexOfQuestion = indexOfQuestion - 1
        }
        else{
            indexOfQuestion = questions.size-1
        }
        updateQuestionText()
    }
    fun updateQuestionText() {
        binding.QuestionTextView.text = getString(questions.get(indexOfQuestion).id)
    }
    fun checkAnswer(answer:Boolean) {
        if (questions.get(indexOfQuestion).answer == answer) {
            Toast.makeText(activity, R.string.toast_message, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(activity, R.string.toast_message2, Toast.LENGTH_SHORT).show()
        }
    }
}