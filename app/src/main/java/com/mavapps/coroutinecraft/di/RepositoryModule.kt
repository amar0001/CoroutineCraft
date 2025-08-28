package com.mavapps.coroutinecraft.di

import com.mavapps.coroutinecraft.data.repository.AuthRepository
import com.mavapps.coroutinecraft.domain.usecase.ValidateEmailUseCase
import com.mavapps.coroutinecraft.domain.usecase.ValidatePasswordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(): AuthRepository = AuthRepository()

    }
