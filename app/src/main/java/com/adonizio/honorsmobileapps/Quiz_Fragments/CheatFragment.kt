package com.adonizio.honorsmobileapps.Quiz_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adonizio.honorsmobileapps.Quiz_Fragments.databinding.FragmentMainBinding

private var _binding: FragmentMainBinding? = null
private val binding get() = _binding!!
class CheatFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        val rootView = binding.root
        return rootView
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}