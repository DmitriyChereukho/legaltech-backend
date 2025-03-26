package ru.hse.legaltech.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "categories")
data class Category (
    @Id
    @Column(name = "id")
    val id: Int,

    @Column(name = "name")
    val name: String
)