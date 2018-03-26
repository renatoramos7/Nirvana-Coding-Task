package com.renatoramos.nirvanacodingtask.commons.di.builder

import com.renatoramos.nirvanacodingtask.commons.di.scope.ActivityScope
import com.renatoramos.nirvanacodingtask.presentation.ui.userdetails.UserDetailsActivity
import com.renatoramos.nirvanacodingtask.presentation.ui.userdetails.module.UserDetailsActivityModule
import com.renatoramos.nirvanacodingtask.presentation.ui.users.UsersActivity
import com.renatoramos.nirvanacodingtask.presentation.ui.users.module.UsersActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by renatoramos on 18.03.18.
 */


@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(UsersActivityModule::class))
    internal abstract fun bindMainActivityModule(): UsersActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(UserDetailsActivityModule::class))
    internal abstract fun bindUserDetailsActivity(): UserDetailsActivity

}
