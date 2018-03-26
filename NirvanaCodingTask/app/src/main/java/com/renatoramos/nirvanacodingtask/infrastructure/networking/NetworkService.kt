package com.renatoramos.nirvanacodingtask.infrastructure.networking

import com.renatoramos.nirvanacodingtask.infrastructure.model.UserData
import com.renatoramos.nirvanacodingtask.infrastructure.model.UserDetailsData
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by renatoramos on 19.03.18.
 */


interface NetworkService {

    @GET("users")
    fun getUsers(): Flowable<List<UserData>>

    @GET("users/{id}")
    fun getUserById(@Path("id") id: Int?): Observable<UserDetailsData>
}
