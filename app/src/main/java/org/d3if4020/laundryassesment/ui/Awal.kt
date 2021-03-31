package org.d3if4020.laundryassesment.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.d3if4020.laundryassesment.R
import org.d3if4020.laundryassesment.databinding.FragmentAwalBinding

class Awal : Fragment() {
    private lateinit var binding: FragmentAwalBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentAwalBinding.inflate(
                layoutInflater, container, false)
        binding.button.setOnClickListener { hitungHarga() }
        return binding.root
    }
    private fun hitungHarga() {
        val bulanan = binding.paketEditText.text.toString()
        if (TextUtils.isEmpty(bulanan)){
            Toast.makeText(context, R.string.bulanan_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val hasil = 25 * 6000 * bulanan.toInt()

        binding.hasilTextView.text = getString(R.string.TotalHarga)
        binding.laundryTextView.text = hasil.toString()
    }
}