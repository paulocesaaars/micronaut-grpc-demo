package com.deviot.adapters.outbound.mappers

import com.deviot.adapters.outbound.persistence.entities.UserEntity
import com.deviot.application.entities.User
import jakarta.inject.Singleton

@Singleton
open class UserMapperRepository {

    fun fromUserEntity(userEntity: UserEntity): User {
        return User(
            userEntity.id,
            userEntity.fullName
        )
    }

    fun fromUsersEntities(userEntities: List<UserEntity>): List<User> {
        var users = mutableListOf<User>()
        userEntities.forEach() {
            users.add(fromUserEntity(it))
        }

        return users.toList()
    }

}