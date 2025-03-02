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
    @PostMapping("/upload")
    fun uploadImage(@RequestParam("file") file: MultipartFile, @RequestBody companyId: Int): ResponseEntity<String> {
        return ResponseEntity.ok(companyImageService.saveImage(file, companyId))
    }
}