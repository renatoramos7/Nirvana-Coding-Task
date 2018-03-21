package com.renatoramos.nirvanacodingtask.commons.di.modules

import android.app.Application
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by renatoramos on 18.03.18.
 */
@Module
open class NetworkModule {

    @Provides
    @Singleton
    internal fun providesOkHttpCache(application: Application): Cache {
        val cacheSize = CACHE_SIZE_10_MB
        val httpCacheDirectory = File(application.cacheDir, CHILD_PATH)
        return Cache(httpCacheDirectory, cacheSize.toLong())
    }

    @Provides
    @Singleton
    internal fun providesGson(): Gson {
        return GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create()
    }

    @Provides
    @Singleton
    internal fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    internal fun providesOkHttpClient(cache: Cache, httpLoggingInterceptor: HttpLoggingInterceptor, application: Application): OkHttpClient {

        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build()
    }

    @Provides
    @Singleton
    internal fun providesGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    internal fun providesRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    internal fun providesRetrofit(gsonConverterFactory: GsonConverterFactory, okHttpClient: OkHttpClient,
                                  rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
                                  @Named(SettingsModule.BASE_URL) baseUrl: String): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build()
    }

    companion object {
        private const val CACHE_SIZE_10_MB = 10 * 1024 * 1024
        private const val TIMEOUT: Long = 5
        private const val CHILD_PATH: String = "responses"
    }
}