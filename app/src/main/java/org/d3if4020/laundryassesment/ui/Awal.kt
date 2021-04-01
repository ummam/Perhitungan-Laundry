package org.d3if4020.laundryassesment.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import org.d3if4020.laundryassesment.R
import org.d3if4020.laundryassesment.databinding.FragmentAwalBinding

class Awal : Fragment() {
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
        if (item.itemId == R.id.menu_about) {
            findNavController().navigate(
                R.id.action_awal_to_aboutFragment)
            return true
        }
        return super.onOptionsItemSelected(item)
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
        binding.buttonGroup.visibility = View.VISIBLE
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

}