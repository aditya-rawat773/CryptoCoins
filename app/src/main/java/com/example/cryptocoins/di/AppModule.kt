package com.example.cryptocoins.di

import android.content.Context
import com.example.cryptocoins.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import io.realm.RealmConfiguration
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val baseUrl = "https://api.wazirx.com/"

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesRealmDatabase(
        @ApplicationContext context: Context
    ): Realm {
        Realm.init(context)
        val realmConfiguration = RealmConfiguration
            .Builder()
            .name("stocks")
            .build()
        Realm.setDefaultConfiguration(realmConfiguration)
        return Realm.getDefaultInstance()
    }

}