package com.deviot.adapters.outbound.persistence

import com.deviot.adapters.outbound.persistence.entities.UserEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface MicronautDataPostgresUserRepository : JpaRepository<UserEntity, UUID> {
}