package com.deviot.adapters.inbound.endpoint

import com.deviot.*
import com.deviot.adapters.inbound.mappers.UserMapper
import com.deviot.adapters.inbound.mappers.UserResponseMapper
import com.deviot.application.entities.PageInfo
import com.deviot.application.ports.UserService
import jakarta.inject.Singleton
import java.util.*

@Singleton
open class UserEndpoint(
    private val userMapper: UserMapper,
    private val userResponseMapper: UserResponseMapper,
    private val userService: UserService
) : UserServiceGrpcKt.UserServiceCoroutineImplBase() {

    override suspend fun findAll(request: UserPageRequest): UsersResponse {
        var users = userService.findAll(PageInfo(request.pageNumber, request.pageSize))
        return userResponseMapper.fromUsers(users)
    }

    override suspend fun findById(request: UserIdRequest): UserResponse {
        var user = userService.findById(UUID.fromString(request.id))
        return userResponseMapper.fromUser(user)
    }

    override suspend fun save(request: NewUserRequest): UserResponse {
        var user = userService.save(userMapper.fromNewUserRequest(request))
        return userResponseMapper.fromUser(user)
    }

    override suspend fun update(request: UserRequest): UserResponse {
        var user = userService.update(userMapper.fromUserRequest(request))
        return userResponseMapper.fromUser(user)
    }

    override suspend fun delete(request: UserIdRequest): UserNoContent {
        userService.delete(UUID.fromString(request.id))
        return UserNoContent.newBuilder().build()
    }
}