package com.deviot.application.ports

import com.deviot.application.entities.PageInfo
import com.deviot.application.entities.User
import java.util.*

interface UserRepository {
    fun findAll(pageInfo: PageInfo) : List<User>
    fun findById(id: UUID) : Optional<User>
    fun save(user: User) : User
    fun update(user: User) : User
    fun delete(user: User)
}