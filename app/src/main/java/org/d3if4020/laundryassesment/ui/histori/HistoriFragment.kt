package org.d3if4020.laundryassesment.ui.histori

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import org.d3if4020.laundryassesment.databinding.FragmentHistoriBinding
import org.d3if4020.laundryassesment.db.LaundryDb

class HistoriFragment  : Fragment() {
    private val viewModel: HistoriViewModel by lazy {
        val db = LaundryDb.getInstance(requireContext())
        val factory = HistoriFactory(db.dao)
        ViewModelProvider(this, factory).get(HistoriViewModel::class.java)
    }

    private lateinit var binding: FragmentHistoriBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentHistoriBinding.inflate(layoutInflater,
            container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.data.observe(viewLifecycleOwner, {
            Log.d("HistoriFragment", "Jumlah data: ${it.size}")
        })
    }
}