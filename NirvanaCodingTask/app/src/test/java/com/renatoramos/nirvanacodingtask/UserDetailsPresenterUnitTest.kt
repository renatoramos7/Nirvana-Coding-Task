package com.renatoramos.nirvanacodingtask

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.renatoramos.nirvanacodingtask.infrastructure.interactors.user.IUserInteractor
import com.renatoramos.nirvanacodingtask.infrastructure.model.UserDetailsData
import com.renatoramos.nirvanacodingtask.presentation.ui.userdetails.UserDetailsContract
import com.renatoramos.nirvanacodingtask.presentation.ui.userdetails.UserDetailsPresenter
import io.reactivex.Observable
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnit

/**
 * Created by renatoramos on 26.03.18.
 */
class UserDetailsPresenterUnitTest {

    @get:Rule
    var rule = MockitoJUnit.rule()

    @Mock
    private lateinit var view: UserDetailsContract.View

    @Mock
    private lateinit var iUserInteractor: IUserInteractor

    @InjectMocks
    private lateinit var presenter: UserDetailsPresenter

    private val userDetailsDataMock = mock<UserDetailsData>()

    private val userID = 1

    @Test
    fun `test OnStart`(){
        // Act
        presenter.onStart()
    }

    @Test
    fun `test set IdUser`(){
        // Act
        presenter.setIdUser(userID)
    }

    @Test
    fun `should get user when internet is online`() {
        // Arrange
        `when`(view.isInternetConnected()).thenReturn(true)
        `when`(iUserInteractor.getUserById(userID, presenter)).thenReturn(Observable.just(userDetailsDataMock))

        // Act
        presenter.getUserDetails(userID)

        // Assert
        verify(iUserInteractor, times(1)).getUserById(userID, presenter)
    }

    @Test
    fun `shouldn't get user when internet is offline`() {
        // Arrange
        `when`(view.isInternetConnected()).thenReturn(false)

        // Act
        presenter.getUserDetails(userID)

        // Assert
        verify(view, times(1)).displayErrorInternetConnection()
    }

    @Test
    fun `get user onSuccess`() {
        // Act
        presenter.onSuccess(userDetailsDataMock)
    }

    @Test
    fun  `get user onError`() {
        // Arrange
        var throwableMock = mock<Throwable>()

        // Act
        presenter.onError(throwableMock)

        // Assert
        verify(view, times(1)).displayError(throwableMock.message.orEmpty())
    }

    @Test
    fun `get user onComplete`() {
        // Act
        presenter.onComplete()
    }

    @Test
    fun testOnStop() {
        // Act
        presenter.onStop()
    }
}