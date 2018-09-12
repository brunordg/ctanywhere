package br.com.codeteam.ctanywhere.base

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface BaseDAO<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg values: T)

    @Delete
    fun delete(value: T)
}