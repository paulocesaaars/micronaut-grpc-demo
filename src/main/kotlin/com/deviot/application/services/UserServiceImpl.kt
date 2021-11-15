package com.deviot.application.services

import com.deviot.application.entities.PageInfo
import com.deviot.application.entities.User
import com.deviot.application.exceptions.NotFoundRegisterException
import com.deviot.application.ports.UserRepository
import com.deviot.application.ports.UserService
import jakarta.inject.Singleton
import java.util.*
import javax.validation.Valid

@Singleton
open class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    private val NOT_FOUND_MESSAGE = "Usuário não encontrado"

    override fun findAll(@Valid pageInfo: PageInfo): List<User> {
        return userRepository.findAll(pageInfo)
    }

    override fun findById(id: UUID): User {
        return userRepository.findById(id).orElseThrow {
            NotFoundRegisterException(NOT_FOUND_MESSAGE)
        }
    }

    override fun save(@Valid user: User): User {
        return userRepository.save(user)
    }

    override fun update(@Valid user: User): User {
        var newUser = findById(user.getId())
        newUser.setFullName(user.getFullName())

        return userRepository.update(newUser)
    }

    override fun delete(id: UUID) {
        var user = findById(id)
        userRepository.delete(user)
    }
}