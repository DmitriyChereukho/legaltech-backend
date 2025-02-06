package ru.hse.legaltech.backend.entity

import jakarta.persistence.*

@Entity
@Table(name = "companies")
class Company(
    @Id
    @Column(name = "id")
    val id: Int,

    @Column(name = "name")
    val name: String,

    @Column(name = "description")
    val description: String,

    @ManyToOne
    @JoinColumn(name = "category_id")
    val category: Category,

    @Column(name = "year_of_launch")
    val yearOfLaunch: Int,

    @Column(name = "linkToProject")
    val linkToProject: String,

    @Column(name = "contacts")
    val contacts: String,

    @Column(name = "founder")
    val founder: String,

    @Column(name = "additional_info")
    val additionalInfo: String
)