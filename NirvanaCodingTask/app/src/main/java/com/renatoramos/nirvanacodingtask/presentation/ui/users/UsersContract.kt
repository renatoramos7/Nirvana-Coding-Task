package com.renatoramos.nirvanacodingtask.presentation.ui.users

import com.renatoramos.nirvanacodingtask.infrastructure.model.base.BaseDisplayableItem

/**
 * Created by renatoramos on 18.03.18.
 */

interface UsersContract {

    interface View {

        fun createAdapter(baseDisplayableList: List<BaseDisplayableItem>)

        fun displayAdapter()

        fun isInternetConnected():Boolean

        fun displayError(error: String)

        fun displayErrorInternetConnection()

        fun openUserDetails(idUser: Int?)
    }

    interface Presenter {

        fun getUsersList()

        fun onOpenUserDetailsScreen(position: Int)
    }
}