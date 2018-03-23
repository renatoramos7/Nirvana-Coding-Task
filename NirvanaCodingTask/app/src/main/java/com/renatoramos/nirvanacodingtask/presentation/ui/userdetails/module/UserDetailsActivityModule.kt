package com.renatoramos.nirvanacodingtask.presentation.ui.userdetails.module

import com.renatoramos.nirvanacodingtask.presentation.ui.userdetails.UserDetailsView
import com.renatoramos.nirvanacodingtask.presentation.ui.userdetails.UserDetailsContract
import com.renatoramos.nirvanacodingtask.presentation.ui.userdetails.UserDetailsPresenter
import dagger.Binds
import dagger.Module

/**
 * Created by renatoramos on 19.03.18.
 */


@Module
abstract class UserDetailsActivityModule {

    @Binds
    internal abstract fun provideMainView(userDetailsActivity: UserDetailsView): UserDetailsContract.View

    @Binds
    internal abstract fun provideUserDetailsPresenter(userDetailsPresenter: UserDetailsPresenter): UserDetailsContract.Presenter
}