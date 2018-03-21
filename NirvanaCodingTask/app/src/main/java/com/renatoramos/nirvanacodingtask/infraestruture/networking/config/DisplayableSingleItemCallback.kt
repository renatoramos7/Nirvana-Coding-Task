package com.renatoramos.nirvanacodingtask.infraestruture.networking.config

import com.renatoramos.nirvanacodingtask.presentation.base.DisplayableItem

/**
 * Created by renatoramos on 21.03.18.
 */
interface DisplayableSingleItemCallback {
    fun onSuccess(displayableItem: DisplayableItem)
    fun onError(throwable: Throwable)
    fun onComplete()
}