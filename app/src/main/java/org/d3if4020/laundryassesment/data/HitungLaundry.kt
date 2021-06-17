package org.d3if4020.laundryassesment.data

import org.d3if4020.laundryassesment.db.LaundryEntity

object HitungLaundry {
    fun hitung(data: LaundryEntity): HasilLaundry {
        val hasil = 25 * 6000 * data.bulanan

        return HasilLaundry(hasil)
    }
}