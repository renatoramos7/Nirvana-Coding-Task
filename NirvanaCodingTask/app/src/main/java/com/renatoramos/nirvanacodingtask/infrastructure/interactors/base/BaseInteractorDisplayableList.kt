package com.renatoramos.nirvanacodingtask.infrastructure.networking.config

import com.renatoramos.nirvanacodingtask.infrastructure.model.base.BaseDisplayableItem

/**
 * Created by renatoramos on 21.03.18.
 */

interface BaseInteractorDisplayableList {
    fun onSuccess(baseDisplayableItemList: List<BaseDisplayableItem>)
    fun onError(throwable: Throwable)
    fun onComplete()
}