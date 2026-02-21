package com.alilopez.kt_demohilt.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // Proveedor para Metales
    @Provides
    @Singleton
    @MetalsRetrofit
    fun provideMetalsRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.metalpriceapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @JsonPlaceHolderRetrofit
    fun provideJsonPlaceHolderRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}