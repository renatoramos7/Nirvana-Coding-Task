package com.renatoramos.nirvanacodingtask.commons.di

import com.renatoramos.nirvanacodingtask.MainApplication
import com.renatoramos.nirvanacodingtask.commons.di.builder.ActivityBuilder
import com.renatoramos.nirvanacodingtask.commons.di.modules.ApplicationModule
import com.renatoramos.nirvanacodingtask.commons.di.modules.NetworkInteractorModule
import com.renatoramos.nirvanacodingtask.commons.di.modules.NetworkModule
import com.renatoramos.nirvanacodingtask.commons.di.modules.SettingsModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by renatoramos on 18.03.18.
 */

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ActivityBuilder::class,
        SettingsModule::class,
        NetworkModule::class,
        NetworkInteractorModule::class))
interface AppComponent {

    fun inject(mainApplication: MainApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(mainApplication: MainApplication): Builder

        fun applicationModule(applicationModule: ApplicationModule): Builder
        fun settingsModule(settingsModule: SettingsModule): Builder
        fun networkModule(networkModule: NetworkModule): Builder
        fun networkInteractorModule(networkInteractorModule: NetworkInteractorModule): Builder
        fun build(): AppComponent
    }
}