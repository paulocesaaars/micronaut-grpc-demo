package com.deviot.adapters.outbound.persistence

import com.deviot.adapters.outbound.mappers.UserEntityMapperRepository
import com.deviot.adapters.outbound.mappers.UserMapperRepository
import com.deviot.application.entities.PageInfo
import com.deviot.application.entities.User
import com.deviot.application.ports.UserRepository
import io.micronaut.data.model.Pageable
import jakarta.inject.Singleton
import java.util.*
import javax.transaction.Transactional
import javax.validation.Valid

@Singleton
open class PostgresUserRepository(
    private val userMapper: UserMapperRepository,
    private val userEntityMapper: UserEntityMapperRepository,
    private val micronautDataPostgresUserRepository: MicronautDataPostgresUserRepository
) : UserRepository {

    override fun findAll(pageInfo: PageInfo): List<User> {
        val pageable = Pageable.from(pageInfo.pageNumber, pageInfo.pageSize)
        val users = micronautDataPostgresUserRepository.findAll(pageable).toList()

        return userMapper.fromUsersEntities(users)
    }

    override fun findById(id: UUID): Optional<User> {
        val user = micronautDataPostgresUserRepository.findById(id)

        if (user.isEmpty)
            return Optional.empty()

        return Optional.ofNullable(userMapper.fromUserEntity(user.get()))
    }

    override fun save(user: User): User {
        val userEntity = micronautDataPostgresUserRepository.save(userEntityMapper.fromUser(user))
        return userMapper.fromUserEntity(userEntity)
    }

    override fun update(user: User): User {
        val userEntity = micronautDataPostgresUserRepository.update(userEntityMapper.fromUser(user))
        return userMapper.fromUserEntity(userEntity)
    }

    override fun delete(user: User) {
        micronautDataPostgresUserRepository.delete(userEntityMapper.fromUser(user))
    }
}