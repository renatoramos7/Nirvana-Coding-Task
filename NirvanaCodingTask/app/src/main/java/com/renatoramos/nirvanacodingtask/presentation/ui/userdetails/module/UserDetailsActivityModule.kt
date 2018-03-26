package com.renatoramos.nirvanacodingtask.presentation.ui.userdetails.module

import com.renatoramos.nirvanacodingtask.presentation.ui.userdetails.UserDetailsActivity
import com.renatoramos.nirvanacodingtask.presentation.ui.userdetails.UserDetailsContract
import dagger.Binds
import dagger.Module

/**
 * Created by renatoramos on 19.03.18.
 */


@Module
abstract class UserDetailsActivityModule {

    @Binds
    internal abstract fun provideMainView(userDetailsActivity: UserDetailsActivity): UserDetailsContract.View

}