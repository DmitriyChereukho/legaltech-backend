package ru.hse.legaltech.backend.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import ru.hse.legaltech.backend.service.CompanyImageService

@RestController
@RequestMapping("/images")
class CompanyImageController(
    private val companyImageService: CompanyImageService
) {
    @PostMapping
    fun uploadImage(@RequestParam("image") file: MultipartFile): ResponseEntity<String> {
        return ResponseEntity.ok(companyImageService.saveImage(file))
    }
}