package com.example.soundboardapp.sounds

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import com.example.soundboardapp.common.enums.Person
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SoundPoolPlayer @Inject constructor(@ApplicationContext context: Context) : AudioPlayer {

    private val priority: Int = 1
    private val maxStreams: Int = 1
    private val srcQuality: Int = 1
    private val leftVolume = 1f
    private val rightVolume = 1f
    private val shouldLoop = 0
    private val playbackRate = 1f
    private val soundPool: SoundPool

    private val persons = mutableMapOf(Person.ZDRAVKO to 0, Person.ELON to 1, Person.DENZEL to 2)

    init {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            val audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build()
            soundPool = SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                .setMaxStreams(maxStreams)
                .build()
        } else {
            soundPool = SoundPool(maxStreams, AudioManager.USE_DEFAULT_STREAM_TYPE, srcQuality)
        }

        persons.forEach { (key, value)->
            persons[key] = soundPool.load(context, key.resource, priority)
        }
    }


    override fun playPersonSound(person: Person) {
        persons[person]?.let {
            soundPool.play(it, leftVolume, rightVolume, priority, shouldLoop, playbackRate)
        }
    }
}