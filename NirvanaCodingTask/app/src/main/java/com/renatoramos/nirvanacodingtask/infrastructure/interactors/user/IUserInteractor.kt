package com.renatoramos.nirvanacodingtask.infrastructure.interactors.user

import com.renatoramos.nirvanacodingtask.infrastructure.interactors.base.BaseInteractor
import com.renatoramos.nirvanacodingtask.infrastructure.networking.config.BaseInteractorDisplayableItem
import com.renatoramos.nirvanacodingtask.infrastructure.networking.config.BaseInteractorDisplayableList
import io.reactivex.observers.DisposableObserver

/**
 * Created by renatoramos on 23.03.18.
 */
interface IUserInteractor : BaseInteractor {

    fun getUsers(baseInteractorDisplayableList: BaseInteractorDisplayableList): DisposableObserver<*>

    fun getUserById(id: Int?, baseInteractorDisplayableItem: BaseInteractorDisplayableItem): DisposableObserver<*>
}