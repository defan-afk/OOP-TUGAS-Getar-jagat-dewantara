package com.ananda.oop2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SiswaDao {
    @Query("SELECT * FROM siswa")
    fun getAll(): List<DataSiswa>

    @Query("SELECT * FROM siswa WHERE `Nomor Induk` IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<DataSiswa>

    @Query("SELECT * FROM siswa WHERE nama_siswa LIKE :nama AND " +
            "nomor_induk LIKE :nomor LIMIT 1")
    fun findByName(first: String, last: String): DataSiswa

    @Insert
    fun insertAll(vararg users: DataSiswa)

    @Delete
    fun delete(user: DataSiswa)
}
