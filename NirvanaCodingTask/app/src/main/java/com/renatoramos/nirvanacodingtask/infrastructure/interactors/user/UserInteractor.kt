package com.renatoramos.nirvanacodingtask.infrastructure.networking.services

import com.renatoramos.nirvanacodingtask.infrastructure.interactors.user.IUserInteractor
import com.renatoramos.nirvanacodingtask.infrastructure.model.UserData
import com.renatoramos.nirvanacodingtask.infrastructure.model.UserDetailsData
import com.renatoramos.nirvanacodingtask.infrastructure.networking.NetworkService
import com.renatoramos.nirvanacodingtask.infrastructure.networking.config.BaseInteractorDisplayableItem
import com.renatoramos.nirvanacodingtask.infrastructure.networking.config.BaseInteractorDisplayableList
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by renatoramos on 19.03.18.
 */

class UserInteractor(private val networkService: NetworkService): IUserInteractor {

   override fun getUsersList(baseInteractorDisplayableList: BaseInteractorDisplayableList): Flowable<List<UserData>> {
        return networkService.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getUserById(id: Int?, baseInteractorDisplayableItem: BaseInteractorDisplayableItem): Observable<UserDetailsData> {
        return networkService.getUserById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}