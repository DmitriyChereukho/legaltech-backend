package ru.hse.legaltech.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Builder
import lombok.Data

@Entity
@Data
@Table(name = "categories")
@Builder
class Category (
    @Id
    @Column(name = "id")
    private val id: Int,

    @Column(name = "name")
    val name: String
)