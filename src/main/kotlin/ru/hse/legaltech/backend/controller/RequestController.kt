package ru.hse.legaltech.backend.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.hse.legaltech.backend.entity.Request
import ru.hse.legaltech.backend.service.RequestService

@RestController
class RequestController(private val requestService: RequestService) {

    @RequestMapping("/requests")
    fun getRequests(): List<Request> {
        return requestService.getRequests()
    }
}