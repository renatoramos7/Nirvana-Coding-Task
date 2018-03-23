package com.renatoramos.nirvanacodingtask.presentation.ui.users.module

import com.renatoramos.nirvanacodingtask.presentation.ui.users.UsersContract
import com.renatoramos.nirvanacodingtask.presentation.ui.users.UsersPresenter
import com.renatoramos.nirvanacodingtask.presentation.ui.users.UsersView
import dagger.Binds
import dagger.Module

/**
 * Created by renatoramos on 18.03.18.
 */
@Module
abstract class UsersActivityModule {

    @Binds
    internal abstract fun provideUsersView(usersActivity: UsersView): UsersContract.View

    @Binds
    internal abstract fun provideUsersPresenter(usersPresenter: UsersPresenter): UsersContract.Presenter

}
