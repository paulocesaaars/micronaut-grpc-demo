package com.deviot.application.entities

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Introspected
class PageInfo(
    @field:Min(0, message = "O número da página não pode ser inferior a 0")
    @field:Max(100, message = "O número da página não pode ser superior a 100")
    val pageNumber: Int,

    @field:Min(0, message = "O número da registros não pode ser inferior a 0")
    val pageSize: Int
) {
}