package ru.hse.legaltech.backend.mapper

import ru.hse.legaltech.backend.entity.Request
import ru.hse.legaltech.backend.model.RequestDto

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
                request.imageFileName,
                request.createdAt,
                request.status
            )
        }
    }
}