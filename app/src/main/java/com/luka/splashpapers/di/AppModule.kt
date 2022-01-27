package com.luka.splashpapers.di

import com.luka.splashpapers.screens.home.service.RecentPhotosService
import com.luka.splashpapers.utils.Constants.BASE_URL_RECENTS
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    private fun interceptorClient(): OkHttpClient {
        val builder = OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
            chain.request().url
            val request = chain.request().newBuilder()
            val response = chain.proceed(request.build())
            response
        })

        builder.addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        return builder.build()
    }

    private fun <T> buildRetro(base: String, service: Class<T>): T {
        return Retrofit.Builder()
            .baseUrl(base)
            .addConverterFactory(GsonConverterFactory.create())
            .client(interceptorClient())
            .build()
            .create(service)
    }

    @Provides
    @Singleton
    fun recentPhotosService(): RecentPhotosService =
        buildRetro(BASE_URL_RECENTS, RecentPhotosService::class.java)
}