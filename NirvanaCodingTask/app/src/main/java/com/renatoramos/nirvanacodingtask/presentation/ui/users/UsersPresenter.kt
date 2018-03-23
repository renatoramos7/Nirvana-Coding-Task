package com.renatoramos.nirvanacodingtask.presentation.ui.users

import com.renatoramos.nirvanacodingtask.infrastructure.model.UserDataClass
import com.renatoramos.nirvanacodingtask.infrastructure.model.base.BaseDisplayableItem
import com.renatoramos.nirvanacodingtask.infrastructure.networking.config.BaseInteractorDisplayableList
import com.renatoramos.nirvanacodingtask.infrastructure.networking.services.UserInteractor
import com.renatoramos.nirvanacodingtask.presentation.base.BasePresenter
import javax.inject.Inject

/**
 * Created by renatoramos on 18.03.18.
 */


class UsersPresenter @Inject constructor(view: UsersContract.View, private val userInteractor: UserInteractor) : BasePresenter<UsersContract.View>(view), UsersContract.Presenter {

    private lateinit var baseDisplayableItemList: List<BaseDisplayableItem>

    override fun onStart() {
        getUsersInServer()
    }

    private fun getUsersInServer() {
        if (mView.isInternetConnected()) {
            addDisposable(userInteractor.getUsers(object : BaseInteractorDisplayableList {

                override fun onSuccess(baseDisplayableItemList: List<BaseDisplayableItem>) {
                    this@UsersPresenter.baseDisplayableItemList = baseDisplayableItemList
                }

                override fun onError(throwable: Throwable) {
                    mView.displayError(throwable.message.orEmpty())
                }

                override fun onComplete() {
                    mView.createAdapter(baseDisplayableItemList)
                    mView.displayAdapter()
                }
            }))
        } else {
            mView.displayErrorInternetConnection()
        }
    }

    override fun onOpenUserDetailsScreen(position: Int) {
        val userDataClass = baseDisplayableItemList[position] as UserDataClass
        mView.openUserDetails(userDataClass.id)
    }
}

