package com.saja.mytask.utils

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {
    @Provides
    fun provideApplicationContext(@ApplicationContext appContext: Context): Context {
        return appContext
    }
}