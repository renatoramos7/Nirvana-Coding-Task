package com.renatoramos.nirvanacodingtask.presentation.ui.userdetails

import com.renatoramos.nirvanacodingtask.infrastructure.model.UserDetailsDataClass
import com.renatoramos.nirvanacodingtask.infrastructure.model.base.BaseDisplayableItem
import com.renatoramos.nirvanacodingtask.infrastructure.networking.config.BaseInteractorDisplayableItem
import com.renatoramos.nirvanacodingtask.infrastructure.networking.services.UserInteractor
import com.renatoramos.nirvanacodingtask.presentation.base.BasePresenter
import javax.inject.Inject

/**
 * Created by renatoramos on 19.03.18.
 */

class UserDetailsPresenter @Inject constructor(view: UserDetailsContract.View, private val userInteractor: UserInteractor): BasePresenter<UserDetailsContract.View>(view), UserDetailsContract.Presenter {

    private var idUser: Int = 0

    override fun onStart() {
        getUserDetails()
    }

    private fun getUserDetails(){

        addDisposable(userInteractor.getUserById(idUser, object : BaseInteractorDisplayableItem {
            override fun onSuccess(baseDisplayableItem: BaseDisplayableItem) {
                loadAllUserDetails(baseDisplayableItem as UserDetailsDataClass)
            }
            override fun onError(throwable: Throwable) {
                mView.displayError(throwable.message.orEmpty())
            }

            override fun onComplete() {

            }
        }))
    }

    override fun setIdUser(idUser: Int) {
       this@UserDetailsPresenter.idUser = idUser
    }

    private fun loadAllUserDetails(userDetailsDataClass: UserDetailsDataClass) {
        mView.showUserDetails(userDetailsDataClass.avatarUrl,
                userDetailsDataClass.name,
                userDetailsDataClass.bio,
                userDetailsDataClass.company,
                userDetailsDataClass.location,
                userDetailsDataClass.htmlUrl)
    }

}