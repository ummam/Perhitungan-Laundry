package org.d3if4020.laundryassesment.ui.hitung

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if4020.laundryassesment.data.HasilLaundry
import org.d3if4020.laundryassesment.data.HitungLaundry
import org.d3if4020.laundryassesment.db.LaundryDao
import org.d3if4020.laundryassesment.db.LaundryEntity

class HitungViewModel(private val db: LaundryDao) : ViewModel() {
    private val hasilLaundry = MutableLiveData<HasilLaundry?>()


    fun hitungHarga(bulanan: String) {

        val dataLaundry = LaundryEntity(
            bulanan = bulanan.toFloat()
        )
        hasilLaundry.value = HitungLaundry.hitung(dataLaundry)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataLaundry)
            }
        }
    }
    fun getHasilLaundry() : LiveData<HasilLaundry?> = hasilLaundry
}