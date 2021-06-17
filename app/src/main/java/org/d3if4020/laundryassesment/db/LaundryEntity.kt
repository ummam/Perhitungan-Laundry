package org.d3if4020.laundryassesment.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "laundry")
data class LaundryEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var bulanan: Float
)
