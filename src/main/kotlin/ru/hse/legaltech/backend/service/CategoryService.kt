package ru.hse.legaltech.backend.service

import org.springframework.stereotype.Service
import ru.hse.legaltech.backend.entity.Category
import ru.hse.legaltech.backend.repository.CategoryRepository

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {
    fun getAllCategories(): List<Category> = categoryRepository.findAll()

    fun getCategoryById(id: Int): Category {
        return categoryRepository.findById(id).get()
    }
}