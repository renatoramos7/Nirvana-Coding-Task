package com.renatoramos.nirvanacodingtask.presentation.ui.users

import com.renatoramos.nirvanacodingtask.presentation.base.DisplayableItem

/**
 * Created by renatoramos on 18.03.18.
 */

interface UsersContract {

    interface View {

        fun createAdapter(displayableList: List<DisplayableItem>)

        fun displayAdapter()

        fun isInternetConnected():Boolean

        fun displayError(error: String)

        fun displayErrorInternetConnection()

        fun openUserDetails(idUser: Int?)
    }

    interface Presenter{

        fun onOpenUserDetailsScreen(position: Int)
    }
}