package com.team.ozet.data.user.repository

import com.team.ozet.api.UserApi
import com.team.ozet.data.user.UserModel
import io.reactivex.Single

class UserRepositoryImpl(private val userApi: UserApi):UserRepository {
    override fun getUser(token: String): Single<UserModel> =userApi.getUser(token)
    override fun patchUserUpdate(token: String, body: UserModel): Single<UserModel> = userApi.patchUserUpdate(token, body)
}