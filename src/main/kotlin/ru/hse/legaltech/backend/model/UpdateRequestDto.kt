package ru.hse.legaltech.backend.model

data class UpdateRequestDto(
    val companyId: Int,

    val name: String,

    val description: String,

    val categoryId: Int,

    val yearOfLaunch: Int,

    val linkToProject: String,

    val additionalInfo: String?,

    val contacts: String,

    val founder: String,

    val imageName: String
)
