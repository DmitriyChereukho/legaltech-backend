package ru.hse.legaltech.backend.controller

import org.springframework.web.bind.annotation.*
import ru.hse.legaltech.backend.model.NewRequestDto
import ru.hse.legaltech.backend.model.RequestDto
import ru.hse.legaltech.backend.model.UpdateForRequestDto
import ru.hse.legaltech.backend.model.UpdateRequestDto
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

    @PostMapping("/update/accept")
    fun acceptUpdateRequest(@RequestBody requestId: Int) {
        requestService.acceptUpdateRequest(requestId)
    }

    @PostMapping("/update/reject")
    fun rejectUpdateRequest(@RequestBody requestId: Int) {
        requestService.rejectUpdateRequest(requestId)
    }

    @PostMapping("/accept")
    fun acceptRequest(@RequestBody requestId: Int) {
        requestService.acceptRequest(requestId)
    }

    @PostMapping("/reject")
    fun rejectRequest(@RequestBody requestId: Int) {
        requestService.rejectRequest(requestId)
    }

    @PutMapping("/update")
    fun updateRequestOfUpdateType(@RequestBody dto: UpdateForRequestDto) {
        requestService.updateRequestOfTypeUpdate(dto)
    }

    @PutMapping
    fun updateRequest(@RequestBody dto: UpdateForRequestDto){
        requestService.updateRequest(dto)
    }
}