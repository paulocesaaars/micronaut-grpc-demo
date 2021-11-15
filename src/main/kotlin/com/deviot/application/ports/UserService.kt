package com.deviot.application.ports

import com.deviot.application.entities.PageInfo
import com.deviot.application.entities.User
import java.util.*

interface UserService {
    fun findAll(pageInfo: PageInfo): List<User>
    fun findById(id: UUID): User
    fun save(user: User): User
    fun update(user: User): User
    fun delete(id: UUID)
}