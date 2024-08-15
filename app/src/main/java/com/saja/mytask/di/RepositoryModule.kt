package com.saja.mytask.di

import android.content.Context
import com.saja.mytask.network.ServiceApi
import com.saja.mytask.repository.LoginRepository
import com.saja.mytask.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

@InstallIn(ViewModelComponent::class)
@Module
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideMainRepository(
        serviceApi: ServiceApi,
    ): MainRepository {
        return MainRepository(serviceApi)
    }

    @Provides
    @ViewModelScoped
    fun provideLoginRepository(
        serviceApi: ServiceApi,
        @ApplicationContext applicationContext: Context
    ): LoginRepository {
        return LoginRepository(serviceApi,applicationContext)
    }
}