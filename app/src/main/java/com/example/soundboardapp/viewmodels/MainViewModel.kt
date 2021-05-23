package com.example.soundboardapp.viewmodels

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.soundboardapp.R
import com.example.soundboardapp.common.enums.Person
import com.example.soundboardapp.sounds.AudioPlayer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val audioPlayer: AudioPlayer
) : ViewModel() {

    fun playPersonSound(view: View) {
        audioPlayer.apply {
            when (view.id) {
                R.id.ibZdravkoMamic -> playPersonSound(Person.ZDRAVKO)
                R.id.ibElonMusk -> playPersonSound(Person.ELON)
                R.id.ibDenzelWashington -> playPersonSound(Person.DENZEL)
            }
        }
    }
}