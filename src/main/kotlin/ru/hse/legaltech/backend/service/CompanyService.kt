package ru.hse.legaltech.backend.service

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import ru.hse.legaltech.backend.entity.Company
import ru.hse.legaltech.backend.entity.Request
import ru.hse.legaltech.backend.mapper.CompanyEntityToCompanyDtoMapper
import ru.hse.legaltech.backend.model.CompanyDto
import ru.hse.legaltech.backend.model.NewRequestDto
import ru.hse.legaltech.backend.model.UpdateRequestDto
import ru.hse.legaltech.backend.repository.CompanyRepository

@Service
class CompanyService(
    private val companyRepository: CompanyRepository,
    private val categoryService: CategoryService,
    private val companyImageService: CompanyImageService,

    ) {
    fun getAllCompanies(): List<CompanyDto> = companyRepository.findAll()
        .stream()
        .map { company -> CompanyEntityToCompanyDtoMapper.toCompanyDto(company) }
        .toList()

    fun getCompanyById(id: Int): Company {
        return companyRepository.findById(id).get()
    }

    fun deleteCompany(id: Int): CompanyDto {
        val deletedCompany = companyRepository.findById(id)

        if (deletedCompany.isEmpty) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Company with id $id not found")
        }
        companyRepository.deleteById(id)

        val imageFileName = deletedCompany.get().imageFileName

        if (!imageFileName.isNullOrEmpty()) {
            companyImageService.deleteImage(imageFileName)
        }

        return CompanyEntityToCompanyDtoMapper.toCompanyDto(deletedCompany.get())
    }

    fun createCompany(newRequestDto: NewRequestDto): CompanyDto {
        val companies = companyRepository.findAll().toList()

        val matchedCompanies = companies.stream()
            .filter { company -> company.name == newRequestDto.name }
            .count()

        if (matchedCompanies > 0) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Company with name ${newRequestDto.name} already exists"
            )
        }

        val company = companyRepository.save(
            Company(
                null,
                newRequestDto.name,
                newRequestDto.description,
                categoryService.getCategoryById(newRequestDto.categoryId),
                newRequestDto.yearOfLaunch,
                newRequestDto.linkToProject,
                newRequestDto.contacts,
                newRequestDto.founder,
                newRequestDto.additionalInfo,
                newRequestDto.imageName
            )
        )

        return CompanyEntityToCompanyDtoMapper.toCompanyDto(company)
    }

    fun updateCompany(updateRequestDto: UpdateRequestDto): CompanyDto {
        val company = companyRepository.findById(updateRequestDto.companyId)

        if (company.isEmpty) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Company with id ${updateRequestDto.companyId} not found"
            )
        }


        val notNullCompany = company.get()

        val updatedCompany = companyRepository.save(
            Company(
                notNullCompany.id,
                updateRequestDto.name,
                updateRequestDto.description,
                categoryService.getCategoryById(updateRequestDto.categoryId),
                updateRequestDto.yearOfLaunch,
                updateRequestDto.linkToProject,
                updateRequestDto.contacts,
                updateRequestDto.founder,
                updateRequestDto.additionalInfo,
                updateRequestDto.imageName
            )
        )

        return CompanyEntityToCompanyDtoMapper.toCompanyDto(updatedCompany)
    }

    fun createCompany(request: Request) {
        companyRepository.save(
            Company(
                null,
                request.name,
                request.description,
                request.category,
                request.yearOfLaunch,
                request.linkToProject,
                request.contacts,
                request.founder,
                request.additionalInfo,
                request.imageFileName
            )
        )
    }
}