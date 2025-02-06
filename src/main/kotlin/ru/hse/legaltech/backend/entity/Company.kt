package ru.hse.legaltech.backend.entity

import jakarta.persistence.*
import lombok.Builder
import lombok.Data

@Entity
@Data
@Table(name = "companies")
@Builder
class Company(
    @Id
    @Column(name = "id")
    private val id: Int,

    @Column(name = "name")
    private val name: String,

    @Column(name = "description")
    private val description: String,

    @ManyToOne
    @JoinColumn(name = "category_id")
    private val category: Category,

    @Column(name = "year_of_launch")
    private val yearOfLaunch: Int,

    @Column(name = "linkToProject")
    private val linkToProject: String,

    @Column(name = "contacts")
    private val contacts: String,

    @Column(name = "founder")
    private val founder: String,

    @Column(name = "additional_info")
    private val additionalInfo: String
)