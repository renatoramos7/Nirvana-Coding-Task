package com.renatoramos.nirvanacodingtask.commons.di.modules

import com.renatoramos.nirvanacodingtask.infrastructure.networking.NetworkService
import com.renatoramos.nirvanacodingtask.infrastructure.networking.services.UserService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by renatoramos on 18.03.18.
 */


@Module
class NetworkServicesModule {

    @Provides
    @Singleton
    fun providesNetworkService(retrofit: Retrofit): NetworkService {
        return retrofit.create(NetworkService::class.java)
    }

    @Provides
    @Singleton
    fun providesService(networkService: NetworkService): UserService {
        return UserService(networkService)
    }
}
