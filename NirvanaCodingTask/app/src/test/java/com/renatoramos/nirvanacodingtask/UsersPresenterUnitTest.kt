package com.renatoramos.nirvanacodingtask

import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.renatoramos.nirvanacodingtask.base.BasePresenterTest
import com.renatoramos.nirvanacodingtask.infrastructure.interactors.user.IUserInteractor
import com.renatoramos.nirvanacodingtask.presentation.ui.users.UsersContract
import com.renatoramos.nirvanacodingtask.presentation.ui.users.UsersPresenter
import org.junit.Assert
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock

/**
 * Created by renatoramos on 22.03.18.
 */

class UsersPresenterUnitTest : BasePresenterTest() {

    @Mock
    lateinit var view: UsersContract.View

    @Mock
    lateinit var iUserInteractor: IUserInteractor

    @InjectMocks
    lateinit var presenter: UsersPresenter


    @Test
    fun testOnStart_firstStart() {
        presenter.onStart()

        verify(iUserInteractor, times(0)).getUsers(presenter)
    }

    
    @Test
    fun addition_isCorrect() {
        Assert.assertEquals(4, 2 + 2)
    }




}