package ru.hse.legaltech.backend.model

import ru.hse.legaltech.backend.entity.Category
import ru.hse.legaltech.backend.enum.RequestStatus
import ru.hse.legaltech.backend.enum.RequestType
import java.time.LocalDateTime

data class RequestDto(
    val id: Int?,

    val name: String,

    val description: String,

    val category: Category,

    val yearOfLaunch: Int,

    val linkToProject: String,

    val additionalInfo: String?,

    val founder: String?,

    val contacts: String?,

    val imagePath: String?,

    val createdAt: LocalDateTime,

    val status: RequestStatus,

    val requestType: RequestType
)
