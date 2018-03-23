package com.renatoramos.nirvanacodingtask

import android.app.Activity
import android.app.Application
import com.renatoramos.nirvanacodingtask.commons.di.DaggerAppComponent
import com.renatoramos.nirvanacodingtask.commons.di.modules.ApplicationModule
import com.renatoramos.nirvanacodingtask.commons.di.modules.NetworkInteractorModule
import com.renatoramos.nirvanacodingtask.commons.di.modules.NetworkModule
import com.renatoramos.nirvanacodingtask.commons.di.modules.SettingsModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by renatoramos on 18.03.18.
 */
open class MainApplication : Application(), HasActivityInjector{

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        init()
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }


    private fun init() {
         initDagger()
    }

    private fun initDagger() {

        DaggerAppComponent
                .builder()
                .application(this)
                .applicationModule(ApplicationModule(this))
                .settingsModule(SettingsModule())
                .networkModule(NetworkModule())
                .networkInteractorModule(NetworkInteractorModule())
                .build()
                .inject(this)
    }

}