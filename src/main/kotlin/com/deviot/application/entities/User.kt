package com.deviot.application.entities

import io.micronaut.core.annotation.Introspected
import java.util.*
import javax.validation.constraints.NotEmpty

@Introspected
class User(
    @field:NotEmpty(message = "O campo id é obrigatório")
    private var id: UUID,

    @field:NotEmpty(message = "O campo nome completo é obrigatório")
    private var fullName: String,
) {
    fun getId(): UUID {
        return id
    }

    fun getFullName(): String {
        return fullName
    }

    fun setFullName(value: String) {
        fullName = value
    }
}