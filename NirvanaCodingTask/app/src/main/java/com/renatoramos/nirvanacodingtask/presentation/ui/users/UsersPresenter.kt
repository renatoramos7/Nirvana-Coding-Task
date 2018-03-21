package com.renatoramos.nirvanacodingtask.presentation.ui.users

import com.renatoramos.nirvanacodingtask.infraestruture.data.UserDataClass
import com.renatoramos.nirvanacodingtask.infraestruture.networking.config.DisplayableItemListCallback
import com.renatoramos.nirvanacodingtask.infraestruture.networking.services.UserService
import com.renatoramos.nirvanacodingtask.presentation.base.BasePresenter
import com.renatoramos.nirvanacodingtask.presentation.base.DisplayableItem
import javax.inject.Inject

/**
 * Created by renatoramos on 18.03.18.
 */


class UsersPresenter @Inject constructor(view: UsersContract.View, private val userService: UserService) : BasePresenter<UsersContract.View>(view), UsersContract.Presenter {

    private lateinit var displayableItemList: List<DisplayableItem>

    override fun startPresenter() {
        getUsersInServer()
    }

    private fun getUsersInServer() {
        if (mView.isInternetConnected()) {
            addDisposable(userService.getUsers(object : DisplayableItemListCallback {

                override fun onSuccess(displayableItemList: List<DisplayableItem>) {
                    this@UsersPresenter.displayableItemList = displayableItemList
                }

                override fun onError(throwable: Throwable) {
                    mView.displayError(throwable.message.orEmpty())
                }

                override fun onComplete() {
                    mView.createAdapter(displayableItemList)
                    mView.displayAdapter()
                }
            }))
        } else {
            mView.displayErrorInternetConnection()
        }
    }

    override fun onOpenUserDetailsScreen(position: Int) {
        val userDataClass = displayableItemList[position] as UserDataClass
        mView.openUserDetails(userDataClass.id)
    }
}

