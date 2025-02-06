package ru.hse.legaltech.backend.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.hse.legaltech.backend.entity.Company

interface CompanyRepository : JpaRepository<Company, Long>