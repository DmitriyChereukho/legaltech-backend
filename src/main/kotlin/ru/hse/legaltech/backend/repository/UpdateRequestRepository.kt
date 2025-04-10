package ru.hse.legaltech.backend.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.hse.legaltech.backend.entity.CompanyUpdateRequest

interface UpdateRequestRepository : JpaRepository<CompanyUpdateRequest, Int>