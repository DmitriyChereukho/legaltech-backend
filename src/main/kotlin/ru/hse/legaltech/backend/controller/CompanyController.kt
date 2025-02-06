package ru.hse.legaltech.backend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import ru.hse.legaltech.backend.model.CompanyDto
import ru.hse.legaltech.backend.service.CompanyService

@RestController
@RequestMapping("/companies")
class CompanyController(
    private val companyService: CompanyService
) {
    @GetMapping
    @ResponseBody
    fun getAllCompanies(): List<CompanyDto> = companyService.getAllCompanies()
}