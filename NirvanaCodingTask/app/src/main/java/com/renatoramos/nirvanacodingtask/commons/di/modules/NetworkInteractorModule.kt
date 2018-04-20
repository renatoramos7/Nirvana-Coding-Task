package com.renatoramos.nirvanacodingtask.commons.di.modules

import com.renatoramos.nirvanacodingtask.infrastructure.interactors.user.IUserInteractor
import com.renatoramos.nirvanacodingtask.infrastructure.networking.NetworkService
import com.renatoramos.nirvanacodingtask.infrastructure.networking.services.UserInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by renatoramos on 23.03.18.
 */

@Module
open class NetworkInteractorModule{

    @Provides
    @Singleton
    fun providesUserInteractor(networkService: NetworkService): IUserInteractor {
        return UserInteractor(networkService)
    }
}