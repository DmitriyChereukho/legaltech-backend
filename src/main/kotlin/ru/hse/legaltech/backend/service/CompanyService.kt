package ru.hse.legaltech.backend.service

import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service
import ru.hse.legaltech.backend.entity.Company
import ru.hse.legaltech.backend.mapper.CompanyEntityToCompanyDtoMapper
import ru.hse.legaltech.backend.model.CompanyDto
import ru.hse.legaltech.backend.repository.CompanyRepository

@Service
class CompanyService(
    private val companyRepository: CompanyRepository
) {
    fun getAllCompanies(): List<CompanyDto> = companyRepository.findAll()
        .stream()
        .map { company -> CompanyEntityToCompanyDtoMapper.toCompanyDto(company) }
        .toList()

    fun getCompanyById(id: Int): Company {
        return companyRepository.findById(id).get()
    }
}