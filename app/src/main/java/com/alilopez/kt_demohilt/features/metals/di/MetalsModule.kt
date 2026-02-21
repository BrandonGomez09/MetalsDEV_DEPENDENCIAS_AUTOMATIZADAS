package com.alilopez.kt_demohilt.features.metals.di

import com.alilopez.kt_demohilt.core.di.MetalsRetrofit
import com.alilopez.kt_demohilt.features.metals.data.datasources.remote.MetalsApi
import com.alilopez.kt_demohilt.features.metals.data.repositories.MetalsRepositoryImpl
import com.alilopez.kt_demohilt.features.metals.domain.repositories.MetalsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MetalsModule {

    @Binds
    @Singleton
    abstract fun bindMetalsRepository(
        metalsRepositoryImpl: MetalsRepositoryImpl
    ): MetalsRepository

    companion object {
        @Provides
        @Singleton
        fun provideMetalsApi(@MetalsRetrofit retrofit: Retrofit): MetalsApi {
            return retrofit.create(MetalsApi::class.java)
        }
    }
}