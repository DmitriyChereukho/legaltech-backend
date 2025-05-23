package ru.hse.legaltech.backend.controller

import org.springframework.web.bind.annotation.*
import ru.hse.legaltech.backend.model.*
import ru.hse.legaltech.backend.service.RequestService

@RestController
@RequestMapping("/requests")
class RequestController(
    private val requestService: RequestService
) {

    @GetMapping
    @ResponseBody
    fun getRequests(): List<RequestDto> {
        return requestService.getRequests()
    }

    @PostMapping
    fun addRequest(@RequestBody request: NewRequestDto) {
        requestService.addRequest(request)
    }

    @PostMapping("/update")
    fun addUpdateRequest(@RequestBody request: UpdateRequestDto) {
        requestService.addUpdateRequest(request)
    }

    @PostMapping("/accept")
    fun acceptRequest(@RequestBody idDto: IdDto) {
        requestService.acceptRequest(idDto.id)
    }

    @PostMapping("/reject")
    fun rejectRequest(@RequestBody idDto: IdDto) {
        requestService.rejectRequest(idDto.id)
    }

    @PutMapping
    fun updateRequest(@RequestBody dto: UpdateForRequestDto){
        requestService.updateRequest(dto)
    }

    @DeleteMapping
    fun deleteRequest(@RequestBody idDto: IdDto) {
        requestService.deleteRequest(idDto.id)
    }
}