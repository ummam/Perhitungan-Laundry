package org.d3if4020.laundryassesment.ui.hitung

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if4020.laundryassesment.data.HasilLaundry
import org.d3if4020.laundryassesment.db.LaundryDao
import org.d3if4020.laundryassesment.db.LaundryEntity

class HitungViewModel(private val db: LaundryDao) : ViewModel() {
    private val hasilLaundry = MutableLiveData<HasilLaundry?>()


    fun hitungHarga(bulanan: String) {
        val hasil = 25 * 6000 * bulanan.toFloat()

        hasilLaundry.value = HasilLaundry(hasil)

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val dataLaundry = LaundryEntity(
                    bulanan = bulanan.toFloat()
                )
                db.insert(dataLaundry)
            }
        }
    }
    fun getHasilLaundry() : LiveData<HasilLaundry?> = hasilLaundry
}