package org.d3if4020.laundryassesment.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if4020.laundryassesment.db.LaundryDao

class HistoriViewModel (private val db: LaundryDao) : ViewModel() {
    val data = db.getLastLaundry()

    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }
}