package com.renatoramos.nirvanacodingtask.commons.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by renatoramos on 18.03.18.
 */

@Module
open class ApplicationModule(private val mApplication: Application) {
    @Provides
    @Singleton
    internal fun provideApplication(): Application {
        return mApplication
    }

    @Provides
    @Singleton
    internal fun provideApplicationContext(): Context {
        return mApplication.applicationContext
    }
}