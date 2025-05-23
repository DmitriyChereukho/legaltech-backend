package ru.hse.legaltech.backend.controller

import org.springframework.web.bind.annotation.*
import ru.hse.legaltech.backend.model.CompanyDto
import ru.hse.legaltech.backend.model.IdDto
import ru.hse.legaltech.backend.model.NewRequestDto
import ru.hse.legaltech.backend.model.UpdateRequestDto
import ru.hse.legaltech.backend.service.CompanyService

@RestController
@RequestMapping("/companies")
class CompanyController(
    private val companyService: CompanyService
) {
    @GetMapping
    @ResponseBody
    fun getAllCompanies(): List<CompanyDto> = companyService.getAllCompanies()

    @DeleteMapping
    @ResponseBody
    fun deleteCompany(@RequestBody idDto: IdDto): CompanyDto = companyService.deleteCompany(idDto.id)

    @PostMapping
    @ResponseBody
    fun addCompany(@RequestBody newRequestDto: NewRequestDto): CompanyDto = companyService.createCompany(newRequestDto)

    @PutMapping
    @ResponseBody
    fun updateCompany(@RequestBody updateRequestDto: UpdateRequestDto): CompanyDto = companyService.updateCompany(updateRequestDto)
}