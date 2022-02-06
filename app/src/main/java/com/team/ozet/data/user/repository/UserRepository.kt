package com.team.ozet.data.user.repository

import com.team.ozet.data.user.UserModel
import io.reactivex.Completable
import io.reactivex.Single

interface UserRepository {

    fun getUser(token:String):Single<UserModel>
    fun patchUserUpdate(token:String,body:UserModel): Completable

}