package ru.hse.legaltech.backend.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.hse.legaltech.backend.entity.Category

interface CategoryRepository : JpaRepository<Category, Int>