package com.ananda.oop2


import androidx.lifecycle.LiveData

class DataSiswaRepository (private val siswaDao: SiswaDao){

    val getAll: List<DataSiswa> = siswaDao.getAll()

    suspend fun addSiswa (dataSiswa: DataSiswa){
        siswaDao.insertAll(dataSiswa)
    }
}