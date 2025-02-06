package ru.hse.legaltech.backend.service

import org.springframework.stereotype.Service
import ru.hse.legaltech.backend.entity.Company
import ru.hse.legaltech.backend.repository.CompanyRepository

@Service
class CompanyService(
    private val companyRepository: CompanyRepository
) {
    fun getAllCompanies(): List<Company> = companyRepository.findAll()
}