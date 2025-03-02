package ru.hse.legaltech.backend.mapper

import ru.hse.legaltech.backend.entity.Company
import ru.hse.legaltech.backend.model.CompanyDto

class CompanyEntityToCompanyDtoMapper {
    companion object {
        fun toCompanyDto(company: Company): CompanyDto {
            return CompanyDto(
                company.id,
                company.name,
                company.description,
                company.category,
                company.yearOfLaunch,
                company.linkToProject,
                company.image.path
            )
        }
    }
}