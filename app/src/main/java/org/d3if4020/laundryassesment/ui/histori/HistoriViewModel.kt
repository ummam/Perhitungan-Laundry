package org.d3if4020.laundryassesment.ui.histori

import androidx.lifecycle.ViewModel
import org.d3if4020.laundryassesment.db.LaundryDao

class HistoriViewModel (db: LaundryDao) : ViewModel() {
    val data = db.getLastLaundry()
}