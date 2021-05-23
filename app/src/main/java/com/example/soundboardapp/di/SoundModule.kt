package com.example.soundboardapp.di

import com.example.soundboardapp.sounds.AudioPlayer
import com.example.soundboardapp.sounds.SoundPoolPlayer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
abstract class SoundModule {
    @Singleton
    @Binds
    abstract fun bindAudioPlayer(
        soundPoolPlayer: SoundPoolPlayer
    ): AudioPlayer
}