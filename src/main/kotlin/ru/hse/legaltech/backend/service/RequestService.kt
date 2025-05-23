package ru.hse.legaltech.backend.service

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import ru.hse.legaltech.backend.entity.Company
import ru.hse.legaltech.backend.entity.Request
import ru.hse.legaltech.backend.enum.RequestStatus
import ru.hse.legaltech.backend.mapper.RequestEntityToRequestDtoMapper
import ru.hse.legaltech.backend.model.NewRequestDto
import ru.hse.legaltech.backend.model.RequestDto
import ru.hse.legaltech.backend.model.UpdateForRequestDto
import ru.hse.legaltech.backend.model.UpdateRequestDto
import ru.hse.legaltech.backend.repository.CompanyRepository
import ru.hse.legaltech.backend.repository.RequestRepository
import java.time.LocalDateTime

@Service
class RequestService(
    private val requestRepository: RequestRepository,
    private val categoryService: CategoryService,
    private val companyService: CompanyService,
    private val companyRepository: CompanyRepository
) {
    fun getRequests(): List<RequestDto> {
        return requestRepository.findAll().stream()
            .map { request ->
                RequestEntityToRequestDtoMapper.toRequestDto(request)
            }
            .toList()
    }

    fun addRequest(requestDto: NewRequestDto) {
        requestRepository.save(
            Request(
                null,
                requestDto.name,
                null,
                requestDto.description,
                categoryService.getCategoryById(requestDto.categoryId),
                requestDto.yearOfLaunch,
                requestDto.linkToProject,
                requestDto.contacts,
                requestDto.founder,
                requestDto.additionalInfo,
                requestDto.imageName,
                LocalDateTime.now(),
                RequestStatus.CREATED
            )
        )
    }

    fun addUpdateRequest(updateRequestDto: UpdateRequestDto) {
        requestRepository.save(
            Request(
                null,
                updateRequestDto.name,
                companyService.getCompanyById(updateRequestDto.companyId),
                updateRequestDto.description,
                categoryService.getCategoryById(updateRequestDto.categoryId),
                updateRequestDto.yearOfLaunch,
                updateRequestDto.linkToProject,
                updateRequestDto.contacts,
                updateRequestDto.founder,
                updateRequestDto.additionalInfo,
                updateRequestDto.imageName,
                LocalDateTime.now(),
                RequestStatus.CREATED
            )
        )
    }

    fun acceptRequest(requestId: Int) {
        val request = requestRepository.findById(requestId)
        if (request.isEmpty) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Request not found")
        }

        val notNullRequest = request.get()

        if (notNullRequest.company == null) {
            companyService.createCompany(notNullRequest)
        } else {
            companyService.updateCompany(RequestEntityToRequestDtoMapper.toUpdateRequestDto(notNullRequest))
        }
        requestRepository.save(
            notNullRequest.copy(
                status = RequestStatus.ACCEPTED
            )
        )
    }

    fun rejectRequest(requestId: Int) {
        val request = requestRepository.findById(requestId)
        if (request.isEmpty) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Request not found")
        }

        val notNullRequest = request.get()
        requestRepository.save(
            notNullRequest.copy(
                status = RequestStatus.REJECTED
            )
        )
    }

    fun updateRequest(dto: UpdateForRequestDto) {
        val request = requestRepository.findById(dto.id)

        if (request.isEmpty) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Request not found")
        }

        val category = categoryService.getCategoryById(dto.categoryId)

        val updatedRequest = request.get().copy(
            name = dto.name,
            description = dto.description,
            yearOfLaunch = dto.yearOfLaunch,
            linkToProject = dto.linkToProject,
            additionalInfo = dto.additionalInfo,
            category = category,
            contacts = dto.contacts,
            founder = dto.founder,
        )

        requestRepository.save(updatedRequest)
    }

    fun deleteRequest(requestId: Int) {
        requestRepository.deleteById(requestId)
    }
}