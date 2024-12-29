package com.example.consumerestapi.ui.viewmodel

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.consumerestapi.MahasiswaApplications

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(aplikasiMahasiswa().container.mahasiswaRepository) }
        initializer { InsertViewModel(aplikasiMahasiswa().container.mahasiswaRepository) }
        initializer { DetailViewModel(createSavedStateHandle(), mahasiswaRepository = aplikasiMahasiswa().container.mahasiswaRepository) }
        initializer { EditViewModel(createSavedStateHandle(), mahasiswaRepository = aplikasiMahasiswa().container.mahasiswaRepository) }
    }
}

    fun CreationExtras. aplikasiMahasiswa (): MahasiswaApplications =
        ( this [ ViewModelProvider . AndroidViewModelFactory .APPLICATION_KEY]  as MahasiswaApplications)