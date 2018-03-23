package com.renatoramos.nirvanacodingtask.infrastructure.networking.config

import com.renatoramos.nirvanacodingtask.infrastructure.model.base.BaseDisplayableItem

/**
 * Created by renatoramos on 21.03.18.
 */
interface BaseInteractorDisplayableItem {
    fun onSuccess(baseDisplayableItem: BaseDisplayableItem)
    fun onError(throwable: Throwable)
    fun onComplete()
}