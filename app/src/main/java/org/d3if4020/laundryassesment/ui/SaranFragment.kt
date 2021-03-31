package org.d3if4020.laundryassesment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if4020.laundryassesment.R
import org.d3if4020.laundryassesment.databinding.FragmentSaranBinding

class SaranFragment : Fragment(){
    private lateinit var binding: FragmentSaranBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentSaranBinding.inflate(
                layoutInflater, container, false)
        binding.textViewSaran.text = getString(R.string.ucapan)
        return binding.root
    }

}