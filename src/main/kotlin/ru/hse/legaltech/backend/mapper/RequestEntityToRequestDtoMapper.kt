package ru.hse.legaltech.backend.mapper

import ru.hse.legaltech.backend.entity.CompanyUpdateRequest
import ru.hse.legaltech.backend.entity.Request
import ru.hse.legaltech.backend.enum.RequestType
import ru.hse.legaltech.backend.model.RequestDto
import ru.hse.legaltech.backend.model.UpdateRequestDto

class RequestEntityToRequestDtoMapper {
    companion object {
        fun toRequestDto(request: Request): RequestDto {
            return RequestDto(
                request.id,
                request.name,
                request.description,
                request.category,
                request.yearOfLaunch,
                request.linkToProject,
                request.additionalInfo,
                request.imageFileName ?: "legal-logo.png",
                request.createdAt,
                request.status,
                RequestType.CREATE
            )
        }

        fun toRequestDto(companyUpdateRequest: CompanyUpdateRequest): RequestDto {
            return RequestDto(
                companyUpdateRequest.id,
                companyUpdateRequest.name,
                companyUpdateRequest.description,
                companyUpdateRequest.category,
                companyUpdateRequest.yearOfLaunch,
                companyUpdateRequest.linkToProject,
                companyUpdateRequest.additionalInfo,
                companyUpdateRequest.imageFileName ?: "legal-logo.png",
                companyUpdateRequest.createdAt,
                companyUpdateRequest.status,
                RequestType.UPDATE
            )
        }
    }
}