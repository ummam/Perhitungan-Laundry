package org.d3if4020.laundryassesment.db

import androidx.room.Entity
import androidx.room.PrimaryKey

class LaundryEntity {
    @Entity(tableName = "laundry")
    data class BmiEntity(
        @PrimaryKey(autoGenerate = true)
        var id: Long = 0L,
        var tanggal: Long = System.currentTimeMillis(),
        var bulanan: Float,
    )
}