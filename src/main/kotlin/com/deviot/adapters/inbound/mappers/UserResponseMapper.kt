package com.deviot.adapters.inbound.mappers

import com.deviot.UserResponse
import com.deviot.UsersResponse
import com.deviot.application.entities.User
import jakarta.inject.Singleton

@Singleton
open class UserResponseMapper {

    fun fromUser(user: User): UserResponse {
        return UserResponse.newBuilder()
            .setId(user.getId().toString())
            .setFullName(user.getFullName())
            .build()
    }

    fun fromUsers(users: List<User>): UsersResponse {
        val usersResponse = UsersResponse.newBuilder()
        users.forEach() {
            usersResponse.addUsers(
                fromUser(it)
            )
        }

        return usersResponse.build()
    }

}