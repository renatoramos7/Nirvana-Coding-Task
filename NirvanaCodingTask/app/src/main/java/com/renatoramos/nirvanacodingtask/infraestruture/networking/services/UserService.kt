package com.renatoramos.nirvanacodingtask.infraestruture.networking.services

import com.renatoramos.nirvanacodingtask.infraestruture.data.UserDataClass
import com.renatoramos.nirvanacodingtask.infraestruture.data.UserDetailsDataClass
import com.renatoramos.nirvanacodingtask.infraestruture.networking.NetworkService
import com.renatoramos.nirvanacodingtask.infraestruture.networking.config.DisplayableItemListCallback
import com.renatoramos.nirvanacodingtask.infraestruture.networking.config.DisplayableSingleItemCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by renatoramos on 19.03.18.
 */

class UserService(private val networkService: NetworkService) {

    fun getUsers(displayableItemListCallback: DisplayableItemListCallback): DisposableObserver<*> {
        return networkService.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<List<UserDataClass>>() {

                    override fun onNext(displayableItemList: List<UserDataClass>) {
                        displayableItemListCallback.onSuccess(displayableItemList)
                    }

                    override fun onError(throwable: Throwable) {
                        displayableItemListCallback.onError(throwable)
                    }

                    override fun onComplete() {
                        displayableItemListCallback.onComplete()
                    }
                })
    }

    fun getUserById(id: Int?, displayableSingleItemCallback: DisplayableSingleItemCallback): DisposableObserver<*> {
        return networkService.getUserById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<UserDetailsDataClass>() {
                    override fun onNext(userDetailsDataClass: UserDetailsDataClass) {
                        displayableSingleItemCallback.onSuccess(userDetailsDataClass)
                    }

                    override fun onError(throwable: Throwable) {
                        displayableSingleItemCallback.onError(throwable)
                    }

                    override fun onComplete() {
                        displayableSingleItemCallback.onComplete()
                    }
                })
    }

}