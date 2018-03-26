package com.renatoramos.nirvanacodingtask.presentation.ui.users.module

import com.renatoramos.nirvanacodingtask.presentation.ui.users.UsersActivity
import com.renatoramos.nirvanacodingtask.presentation.ui.users.UsersContract
import dagger.Binds
import dagger.Module

/**
 * Created by renatoramos on 18.03.18.
 */
@Module
abstract class UsersActivityModule {

    @Binds
    internal abstract fun provideUsersView(usersActivity: UsersActivity): UsersContract.View
}
