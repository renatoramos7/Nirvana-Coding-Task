package com.renatoramos.nirvanacodingtask


import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.renatoramos.nirvanacodingtask.infrastructure.interactors.user.IUserInteractor
import com.renatoramos.nirvanacodingtask.infrastructure.model.UserData
import com.renatoramos.nirvanacodingtask.infrastructure.model.base.BaseDisplayableItem
import com.renatoramos.nirvanacodingtask.presentation.ui.users.UsersContract
import com.renatoramos.nirvanacodingtask.presentation.ui.users.UsersPresenter
import io.reactivex.Flowable
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnit


/**
 * Created by renatoramos on 22.03.18.
 */

class UsersPresenterUnitTest {

    @get:Rule
    var rule = MockitoJUnit.rule()

    @Mock
    private lateinit var view: UsersContract.View

    @Mock
    private lateinit var iUserInteractor: IUserInteractor

    @InjectMocks
    private lateinit var presenter: UsersPresenter

   private  val userDataList = ArrayList<UserData>()


    @Test
    fun `test OnStart`(){
        // Act
        presenter.onStart()
    }


    @Test
    fun `should get user list when internet is online`() {
        // Arrange
        `when`(view.isInternetConnected()).thenReturn(true)
        `when`(iUserInteractor.getUsersList(presenter)).thenReturn(Flowable.just(userDataList))

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
    fun `get user list onSuccess`() {
        // Arrange
        var baseDisplayableItemListMock = mock<List<BaseDisplayableItem>>()

        // Act
        presenter.onSuccess(baseDisplayableItemListMock)
    }

    @Test
    fun  `get user list onError`() {
        // Arrange
        var throwableMock = mock<Throwable>()

        // Act
        presenter.onError(throwableMock)

        // Assert
        verify(view, times(1)).displayError(throwableMock.message.orEmpty())
    }

    @Test
    fun `get user list onComplete`() {
        // Arrange
        var baseDisplayableItemListMock = mock<List<BaseDisplayableItem>>()

        // Act
        presenter.onSuccess(baseDisplayableItemListMock)
        presenter.onComplete()

        // Act
        verify(view, times(1)).createAdapter(baseDisplayableItemListMock)
        verify(view, times(1)).displayAdapter()
    }


    @Test
    fun `should open User Details Screen`() {
        // Arrange
        var userMock = mock<UserData>()
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

}