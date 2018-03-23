package com.renatoramos.nirvanacodingtask.commons.di.modules

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by renatoramos on 18.03.18.
 */
@Module
open class SettingsModule {

    @Provides
    @Singleton
    @Named(BASE_URL)
    internal fun provideServerUrl(): String {
        return "https://api.github.com/"
    }

    companion object {
        const val BASE_URL = "Settings.ServerUrl"
    }
}