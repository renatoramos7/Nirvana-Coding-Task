package com.renatoramos.nirvanacodingtask.presentation.ui.users

import com.renatoramos.nirvanacodingtask.infrastructure.interactors.user.IUserInteractor
import com.renatoramos.nirvanacodingtask.infrastructure.model.UserData
import com.renatoramos.nirvanacodingtask.infrastructure.model.base.BaseDisplayableItem
import com.renatoramos.nirvanacodingtask.infrastructure.networking.config.BaseInteractorDisplayableList
import com.renatoramos.nirvanacodingtask.presentation.base.BasePresenter
import javax.inject.Inject

/**
 * Created by renatoramos on 18.03.18.
 */


class UsersPresenter @Inject constructor(view: UsersContract.View, private val iUserInteractor: IUserInteractor) : BasePresenter<UsersContract.View>(view),
        UsersContract.Presenter, BaseInteractorDisplayableList {

    private var baseDisplayableItemList: List<BaseDisplayableItem> = listOf()

    override fun onStart() {
        getUsersList()
    }

    override fun getUsersList() {
        if (mView.isInternetConnected()) {
            addDisposable(iUserInteractor.getUsersList(this)
                    .subscribe(
                            { list -> onSuccess(list) },
                            { throwable -> onError(throwable) },
                            { onComplete() }
                    ))
        } else {
            mView.displayErrorInternetConnection()
        }
    }

    override fun onSuccess(baseDisplayableItemList: List<BaseDisplayableItem>) {
        this.baseDisplayableItemList = baseDisplayableItemList
    }

    override fun onError(throwable: Throwable) {
        mView.displayError(throwable.message.orEmpty())
    }

    override fun onComplete() {
        mView.createAdapter(baseDisplayableItemList)
        mView.displayAdapter()
    }


    override fun onOpenUserDetailsScreen(position: Int) {
        val userDataClass = baseDisplayableItemList[position] as UserData
        mView.openUserDetails(userDataClass.id)
    }
}

