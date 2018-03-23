package com.renatoramos.nirvanacodingtask.infrastructure.networking.config

import com.renatoramos.nirvanacodingtask.infrastructure.model.base.BaseDisplayableItem

/**
 * Created by renatoramos on 21.03.18.
 */

interface BaseInteractorDisplayableList {
    fun onApiSuccess(baseDisplayableItemList: List<BaseDisplayableItem>)
    fun onApiError(throwable: Throwable)
    fun onApiComplete()
}