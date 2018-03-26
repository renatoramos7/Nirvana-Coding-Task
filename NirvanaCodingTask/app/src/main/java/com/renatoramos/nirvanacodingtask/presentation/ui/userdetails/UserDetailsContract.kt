package com.renatoramos.nirvanacodingtask.presentation.ui.userdetails

/**
 * Created by renatoramos on 19.03.18.
 */


interface UserDetailsContract {

    interface View {

         fun showUserDetails(avatarUrl: String?, name: String?, bio: String?, company: String?, location: String?, repo: String?)

        fun isInternetConnected():Boolean

         fun displayErrorInternetConnection()

         fun displayError(apiError: String)
    }

    interface Presenter {

        fun setIdUser(idUser : Int)

        fun getUserDetails(idUser : Int)
    }
}