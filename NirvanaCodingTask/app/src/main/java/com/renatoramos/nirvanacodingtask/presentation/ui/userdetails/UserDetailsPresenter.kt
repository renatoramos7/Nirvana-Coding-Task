package com.renatoramos.nirvanacodingtask.presentation.ui.userdetails

import com.renatoramos.nirvanacodingtask.infraestruture.data.UserDetailsDataClass
import com.renatoramos.nirvanacodingtask.infraestruture.networking.config.DisplayableSingleItemCallback
import com.renatoramos.nirvanacodingtask.infraestruture.networking.services.UserService
import com.renatoramos.nirvanacodingtask.presentation.base.BasePresenter
import com.renatoramos.nirvanacodingtask.presentation.base.DisplayableItem
import javax.inject.Inject

/**
 * Created by renatoramos on 19.03.18.
 */

class UserDetailsPresenter @Inject constructor(view: UserDetailsContract.View, private val userService: UserService): BasePresenter<UserDetailsContract.View>(view), UserDetailsContract.Presenter {

    private var idUser: Int = 0

    override fun startPresenter() {
        getUserDetails()
    }

    private fun getUserDetails(){

        addDisposable(userService.getUserById(idUser, object : DisplayableSingleItemCallback {
            override fun onSuccess(displayableItem: DisplayableItem) {
                loadAllUserDetails(displayableItem as UserDetailsDataClass)
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