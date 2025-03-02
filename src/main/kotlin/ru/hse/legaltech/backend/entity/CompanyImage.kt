package ru.hse.legaltech.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "company_images")
data class CompanyImage(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "path")
    val path: String
)
