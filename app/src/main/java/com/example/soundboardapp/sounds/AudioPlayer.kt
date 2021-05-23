package com.example.soundboardapp.sounds

import com.example.soundboardapp.common.enums.Person

interface AudioPlayer {
    fun playPersonSound(person: Person)
}