package com.deviot.adapters.outbound.persistence.entities

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_user")
class UserEntity(
    @Id
    var id: UUID,

    @Column(nullable = false)
    var fullName: String,
) {

}