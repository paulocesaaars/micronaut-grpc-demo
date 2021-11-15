package com.deviot.adapters.inbound.mappers

import com.deviot.NewUserRequest
import com.deviot.UserRequest
import com.deviot.application.entities.User
import jakarta.inject.Singleton
import java.util.*

@Singleton
open class UserMapper {

    fun fromNewUserRequest(newUserRequest: NewUserRequest): User {
        return User(UUID.randomUUID(), newUserRequest.fullName)
    }

    fun fromUserRequest(userRequest: UserRequest): User {
        return User(UUID.fromString(userRequest.id), userRequest.fullName)
    }

}