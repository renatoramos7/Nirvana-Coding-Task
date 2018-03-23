package com.renatoramos.nirvanacodingtask.infrastructure.networking

import com.renatoramos.nirvanacodingtask.infrastructure.model.UserDataClass
import com.renatoramos.nirvanacodingtask.infrastructure.model.UserDetailsDataClass
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by renatoramos on 19.03.18.
 */


interface NetworkService {

    @GET("users")
    fun getUsers(): Observable<List<UserDataClass>>

    @GET("users/{id}")
    fun getUserById(@Path("id") id: Int?): Observable<UserDetailsDataClass>
}
