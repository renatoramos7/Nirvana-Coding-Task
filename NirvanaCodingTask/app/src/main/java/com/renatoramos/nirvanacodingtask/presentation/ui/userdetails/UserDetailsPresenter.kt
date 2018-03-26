package com.renatoramos.nirvanacodingtask.presentation.ui.userdetails

import com.renatoramos.nirvanacodingtask.infrastructure.interactors.user.IUserInteractor
import com.renatoramos.nirvanacodingtask.infrastructure.model.UserDetailsData
import com.renatoramos.nirvanacodingtask.infrastructure.model.base.BaseDisplayableItem
import com.renatoramos.nirvanacodingtask.infrastructure.networking.config.BaseInteractorDisplayableItem
import com.renatoramos.nirvanacodingtask.presentation.base.BasePresenter
import javax.inject.Inject

/**
 * Created by renatoramos on 19.03.18.
 */

class UserDetailsPresenter @Inject constructor(view: UserDetailsContract.View, private val iUserInteractor: IUserInteractor): BasePresenter<UserDetailsContract.View>(view),
        UserDetailsContract.Presenter, BaseInteractorDisplayableItem {

    private var idUser: Int = 0

    override fun onStart() {
        getUserDetails(idUser)
    }

    override fun getUserDetails(idUser : Int){
        if (mView.isInternetConnected()) {
            addDisposable(iUserInteractor.getUserById(idUser, this)
                    .subscribe(
                            { baseDisplayableItem -> onSuccess(baseDisplayableItem) },
                            { throwable -> onError(throwable) },
                            { onComplete() }
                    ))
        } else {
            mView.displayErrorInternetConnection()
        }
    }

    override fun onSuccess(baseDisplayableItem: BaseDisplayableItem) {
        loadAllUserDetails(baseDisplayableItem as UserDetailsData)
    }

    override fun onError(throwable: Throwable) {
        mView.displayError(throwable.message.orEmpty())
    }

    override fun onComplete() {}

    override fun setIdUser(idUser: Int) {
       this.idUser = idUser
    }

    private fun loadAllUserDetails(userDetailsData: UserDetailsData) {
        mView.showUserDetails(userDetailsData.avatarUrl,
                userDetailsData.name,
                userDetailsData.bio,
                userDetailsData.company,
                userDetailsData.location,
                userDetailsData.htmlUrl)
    }

}