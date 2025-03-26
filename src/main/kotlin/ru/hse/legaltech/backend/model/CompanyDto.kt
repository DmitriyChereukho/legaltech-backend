package ru.hse.legaltech.backend.model

import ru.hse.legaltech.backend.entity.Category

data class CompanyDto(
    val id: Int?,

    val name: String,

    val description: String?,

    val category: Category,

    val yearOfLaunch: Int?,

    val linkToProject: String?,

    val additionalInfo: String?,

    val imagePath: String?
)