package com.renatoramos.nirvanacodingtask.presentation.ui.users

import com.renatoramos.nirvanacodingtask.infrastructure.interactors.user.IUserInteractor
import com.renatoramos.nirvanacodingtask.infrastructure.model.UserDataClass
import com.renatoramos.nirvanacodingtask.infrastructure.model.base.BaseDisplayableItem
import com.renatoramos.nirvanacodingtask.infrastructure.networking.config.BaseInteractorDisplayableList
import com.renatoramos.nirvanacodingtask.presentation.base.BasePresenter
import javax.inject.Inject

/**
 * Created by renatoramos on 18.03.18.
 */


class UsersPresenter @Inject constructor(view: UsersContract.View, private val iUserInteractor: IUserInteractor) : BasePresenter<UsersContract.View>(view),
        UsersContract.Presenter, BaseInteractorDisplayableList {

    private lateinit var baseDisplayableItemList: List<BaseDisplayableItem>

    override fun onStart() {
        getUsersInServer()
    }

    private fun getUsersInServer() {
        if (mView.isInternetConnected()) {
            addDisposable(iUserInteractor.getUsers(this@UsersPresenter))
        } else {
            mView.displayErrorInternetConnection()
        }
    }

    override fun onApiSuccess(baseDisplayableItemList: List<BaseDisplayableItem>) {
        this@UsersPresenter.baseDisplayableItemList = baseDisplayableItemList
    }

    override fun onApiError(throwable: Throwable) {
        mView.displayError(throwable.message.orEmpty())
    }

    override fun onApiComplete() {
        mView.createAdapter(baseDisplayableItemList)
        mView.displayAdapter()
    }


    override fun onOpenUserDetailsScreen(position: Int) {
        val userDataClass = baseDisplayableItemList[position] as UserDataClass
        mView.openUserDetails(userDataClass.id)
    }
}

