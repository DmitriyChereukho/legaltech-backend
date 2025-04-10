package ru.hse.legaltech.backend.model

import jakarta.persistence.Column
import ru.hse.legaltech.backend.entity.Category

data class CompanyDto(
    val id: Int?,

    val name: String,

    val description: String?,

    val category: Category,

    val yearOfLaunch: Int?,

    val linkToProject: String?,

    val contacts: String?,

    val founder: String?,

    val additionalInfo: String?,

    val imagePath: String?
)