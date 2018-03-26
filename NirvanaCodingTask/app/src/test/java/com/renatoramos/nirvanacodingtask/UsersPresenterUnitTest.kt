package com.renatoramos.nirvanacodingtask

import com.renatoramos.nirvanacodingtask.base.BasePresenterTest
import com.renatoramos.nirvanacodingtask.infrastructure.interactors.user.IUserInteractor
import com.renatoramos.nirvanacodingtask.infrastructure.model.UserData
import com.renatoramos.nirvanacodingtask.presentation.ui.users.UsersContract
import com.renatoramos.nirvanacodingtask.presentation.ui.users.UsersPresenter
import io.reactivex.Flowable
import org.junit.After
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*


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

  /*  @Before
    fun setup() {

    }*/

    @Test
    fun testOnStart_firstStart() {
        // Arrange
        `when`(view.isInternetConnected()).thenReturn(true)
        `when`(iUserInteractor.getUsersList(presenter)).thenReturn(Flowable.just(listOf()))

        // Act
        presenter.onStart()

        // Assert
        verify(iUserInteractor, times(1)).getUsersList(presenter)
    }


    @Test
    fun `should get user list when internet is online`() {
        // Arrange
        `when`(view.isInternetConnected()).thenReturn(true)
        `when`(iUserInteractor.getUsersList(presenter)).thenReturn(Flowable.just(listOf()))

        // Act
        presenter.getUsersList()

        // Assert
        verify(iUserInteractor, times(1)).getUsersList(presenter)
    }

    @Test
    fun `shouldn't get user list when internet is offline`() {
        // Arrange
        `when`(view.isInternetConnected()).thenReturn(false)

        // Act
        presenter.getUsersList()

        // Assert
        verify(view, times(1)).displayErrorInternetConnection()
    }


    @Test
    fun `should open User Details Screen`() {
        // Arrange
       // val user = UserData()

        val userMock = mock(UserData::class.java)
        `when`(userMock.id).thenReturn(1)
        presenter.onSuccess(listOf(userMock))

        // Act
        presenter.onOpenUserDetailsScreen(0)

        // Assert
        verify(view, times(1)).openUserDetails(1)
    }


    @Test
    fun testOnStop() {
        presenter.onStop()
    }

    @After
    fun tearDown() {
        verifyNoMoreInteractions(view, iUserInteractor)
    }

}