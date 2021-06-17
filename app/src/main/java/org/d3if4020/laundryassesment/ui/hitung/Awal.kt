package org.d3if4020.laundryassesment.ui.hitung

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import org.d3if4020.laundryassesment.R
import org.d3if4020.laundryassesment.databinding.FragmentAwalBinding
import org.d3if4020.laundryassesment.db.LaundryDb
import org.d3if4020.laundryassesment.ui.hitung.HitungViewModel

class Awal : Fragment() {
    private val viewModel: HitungViewModel by lazy {
        val db = LaundryDb.getInstance(requireContext())
        val factory = HitungFactory(db.dao)
        ViewModelProvider(this, factory).get(HitungViewModel::class.java)
    }
    private lateinit var binding: FragmentAwalBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentAwalBinding.inflate(
                layoutInflater, container, false)
        binding.button.setOnClickListener { hitungHarga() }
        binding.lanjutButton.setOnClickListener { view: View ->
            view.findNavController().navigate(
                R.id.action_awal_to_saranFragment
            )
        }
        binding.shareButton.setOnClickListener { shareData() }
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_histori -> {
                findNavController().navigate(R.id.action_awal_to_historiFragment)
                return true
            }
            R.id.menu_about -> {
                findNavController().navigate(R.id.action_awal_to_aboutFragment)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun hitungHarga() {
        val bulanan = binding.paketEditText.text.toString()
        if (TextUtils.isEmpty(bulanan)){
            Toast.makeText(context, R.string.bulanan_invalid, Toast.LENGTH_LONG).show()
            return
        }
        viewModel.hitungHarga(bulanan)
    }
    private fun shareData() {
        val message = getString(R.string.bagikan_template,
            binding.paketEditText.text,
            binding.laundryTextView.text
        )
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getHasilLaundry().observe(viewLifecycleOwner,{
            if (it == null) return@observe
            binding.laundryTextView.text = getString(R.string.total, it.hasil)
            binding.buttonGroup.visibility = View.VISIBLE
        })
    }
}