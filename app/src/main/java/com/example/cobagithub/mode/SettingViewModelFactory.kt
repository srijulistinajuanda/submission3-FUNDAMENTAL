package com.example.cobagithub.mode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cobagithub.model.SettingsViewModel

class SettingViewModelFactory(private val pref: SharedPref) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingsViewModel::class.java)) {
            return SettingsViewModel(pref) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}