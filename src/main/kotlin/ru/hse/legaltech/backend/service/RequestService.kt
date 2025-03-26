package ru.hse.legaltech.backend.service

import org.springframework.stereotype.Service
import ru.hse.legaltech.backend.entity.Company
import ru.hse.legaltech.backend.entity.Request
import ru.hse.legaltech.backend.enum.RequestStatus
import ru.hse.legaltech.backend.mapper.RequestEntityToRequestDtoMapper
import ru.hse.legaltech.backend.model.NewRequestDto
import ru.hse.legaltech.backend.model.RequestDto
import ru.hse.legaltech.backend.repository.CompanyRepository
import ru.hse.legaltech.backend.repository.RequestRepository
import java.time.LocalDateTime

@Service
class RequestService(
    private val requestRepository: RequestRepository,
    private val categoryService: CategoryService,
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

    fun acceptRequest(requestId: Int) {
        val request = requestRepository.findById(requestId)
        if (request.isPresent) {
            val notNullRequest = request.get()
            requestRepository.save(
                notNullRequest.copy(
                    status = RequestStatus.ACCEPTED
                )
            )

            companyRepository.save(
                Company(
                    null,
                    notNullRequest.name,
                    notNullRequest.description,
                    notNullRequest.category,
                    notNullRequest.yearOfLaunch,
                    notNullRequest.linkToProject,
                    notNullRequest.contacts,
                    notNullRequest.founder,
                    notNullRequest.additionalInfo,
                    notNullRequest.imageFileName
                )
            )
        }
    }

    fun rejectRequest(requestId: Int) {
        val request = requestRepository.findById(requestId)
        if (request.isPresent) {
            val notNullRequest = request.get()
            requestRepository.save(
                notNullRequest.copy(
                    status = RequestStatus.REJECTED
                )
            )
        }
    }
}