package org.d3if4020.laundryassesment.ui.hitung

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if4020.laundryassesment.data.HasilLaundry

class HitungViewModel : ViewModel() {
    private val hasilLaundry = MutableLiveData<HasilLaundry?>()

    fun hitungHarga(bulanan: String) {
        val hasil = 25 * 6000 * bulanan.toFloat()

        hasilLaundry.value = HasilLaundry(hasil)
    }
    fun getHasilLaundry() : LiveData<HasilLaundry?> = hasilLaundry
}