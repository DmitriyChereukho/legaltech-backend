package ru.hse.legaltech.backend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import ru.hse.legaltech.backend.entity.Category
import ru.hse.legaltech.backend.service.CategoryService

@RestController
@RequestMapping("/categories")
class CategoryController(
    private val categoryService: CategoryService
) {
    @GetMapping
    @ResponseBody
    fun getAllCategories(): List<Category> = categoryService.getAllCategories()
}