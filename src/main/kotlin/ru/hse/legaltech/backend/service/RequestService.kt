package ru.hse.legaltech.backend.service

import org.springframework.stereotype.Service
import ru.hse.legaltech.backend.entity.Request
import ru.hse.legaltech.backend.repository.RequestRepository

@Service
class RequestService(
    private val requestRepository: RequestRepository
) {
    fun getRequests(): List<Request> {
        return requestRepository.findAll()
    }
}