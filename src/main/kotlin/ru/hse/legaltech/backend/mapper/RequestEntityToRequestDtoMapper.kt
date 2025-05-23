package ru.hse.legaltech.backend.mapper

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
                request.founder,
                request.contacts,
                request.imageFileName ?: "legal-logo.png",
                request.createdAt,
                request.status,
                if (request.company == null) RequestType.CREATE else RequestType.UPDATE
            )
        }

        fun toUpdateRequestDto(request: Request): UpdateRequestDto {
            return UpdateRequestDto(
                request.company!!.id!!,
                request.name,
                request.description,
                request.category.id,
                request.yearOfLaunch,
                request.linkToProject,
                request.additionalInfo,
                request.founder,
                request.contacts,
                request.imageFileName ?: "legal-logo.png"
            )
        }
    }
}