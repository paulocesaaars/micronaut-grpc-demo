package com.deviot.adapters.outbound.mappers

import com.deviot.adapters.outbound.persistence.entities.UserEntity
import com.deviot.application.entities.User
import jakarta.inject.Singleton

@Singleton
open class UserEntityMapperRepository {

    fun fromUser(user: User): UserEntity {
        return UserEntity(
            user.getId(),
            user.getFullName()
        )
    }
}