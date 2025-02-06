package ru.hse.legaltech.backend.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.hse.legaltech.backend.entity.Request
import java.util.UUID

interface RequestRepository : JpaRepository<Request, UUID>