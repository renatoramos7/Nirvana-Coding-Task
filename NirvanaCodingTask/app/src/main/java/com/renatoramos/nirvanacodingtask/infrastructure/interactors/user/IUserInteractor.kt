package com.renatoramos.nirvanacodingtask.infrastructure.interactors.user

import com.renatoramos.nirvanacodingtask.infrastructure.model.UserData
import com.renatoramos.nirvanacodingtask.infrastructure.model.UserDetailsData
import com.renatoramos.nirvanacodingtask.infrastructure.networking.config.BaseInteractorDisplayableItem
import com.renatoramos.nirvanacodingtask.infrastructure.networking.config.BaseInteractorDisplayableList
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * This interface is because Unit tests.
 */
interface IUserInteractor {

    fun getUsersList(baseInteractorDisplayableList: BaseInteractorDisplayableList): Flowable<List<UserData>>

    fun getUserById(id: Int?, baseInteractorDisplayableItem: BaseInteractorDisplayableItem): Observable<UserDetailsData>

}