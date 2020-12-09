package com.ananda.oop2


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.oop.oop2.GuruRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DataSiswaModelView(aplication: Application): AndroidViewModel(aplication){
    private val readAllData: List<DataSiswa>
    private val repository: DataSiswaRepository

    init {
        val datasiswaDao = SiswaDatabase.getDatabase(aplication).siswaDao()
        repository = DataSiswaRepository(datasiswaDao)
        readAllData =repository.getAll
    }

    fun addDataSiswa(dataSiswa: DataSiswa){
        viewModelScope.launch (Dispatchers.IO){
            repository.addSiswa(dataSiswa)
        }
    }

}