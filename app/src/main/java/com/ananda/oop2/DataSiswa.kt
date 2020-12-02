package com.ananda.oop2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "siswa")
data class DataSiswa(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "Nama Siswa") val namaSiswa: String?,
    @ColumnInfo(name = "Nomor Induk") val nomorInduk: String?
)