package com.renatoramos.nirvanacodingtask.infraestruture.networking.config

import com.renatoramos.nirvanacodingtask.presentation.base.DisplayableItem

/**
 * Created by renatoramos on 21.03.18.
 */

interface DisplayableItemListCallback {
    fun onSuccess(displayableItemList: List<DisplayableItem>)
    fun onError(throwable: Throwable)
    fun onComplete()
}