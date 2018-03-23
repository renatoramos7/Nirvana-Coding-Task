package com.renatoramos.nirvanacodingtask.infrastructure.networking.services

import com.renatoramos.nirvanacodingtask.infrastructure.model.UserDataClass
import com.renatoramos.nirvanacodingtask.infrastructure.model.UserDetailsDataClass
import com.renatoramos.nirvanacodingtask.infrastructure.networking.NetworkService
import com.renatoramos.nirvanacodingtask.infrastructure.networking.config.BaseInteractorDisplayableItem
import com.renatoramos.nirvanacodingtask.infrastructure.networking.config.BaseInteractorDisplayableList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by renatoramos on 19.03.18.
 */

class UserInteractor(private val networkService: NetworkService) {

    fun getUsers(baseInteractorDisplayableList: BaseInteractorDisplayableList): DisposableObserver<*> {
        return networkService.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<List<UserDataClass>>() {

                    override fun onNext(displayableItemList: List<UserDataClass>) {
                        baseInteractorDisplayableList.onSuccess(displayableItemList)
                    }

                    override fun onError(throwable: Throwable) {
                        baseInteractorDisplayableList.onError(throwable)
                    }

                    override fun onComplete() {
                        baseInteractorDisplayableList.onComplete()
                    }
                })
    }

    fun getUserById(id: Int?, baseInteractorDisplayableItem: BaseInteractorDisplayableItem): DisposableObserver<*> {
        return networkService.getUserById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<UserDetailsDataClass>() {
                    override fun onNext(userDetailsDataClass: UserDetailsDataClass) {
                        baseInteractorDisplayableItem.onSuccess(userDetailsDataClass)
                    }

                    override fun onError(throwable: Throwable) {
                        baseInteractorDisplayableItem.onError(throwable)
                    }

                    override fun onComplete() {
                        baseInteractorDisplayableItem.onComplete()
                    }
                })
    }

}