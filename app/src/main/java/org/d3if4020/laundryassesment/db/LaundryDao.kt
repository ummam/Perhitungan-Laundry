package org.d3if4020.laundryassesment.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LaundryDao {
    @Insert
    fun insert(laundry: LaundryEntity)
    @Query("SELECT * FROM laundry ORDER BY id DESC LIMIT 1")
    fun getLastLaundry(): LiveData<LaundryEntity?>
}