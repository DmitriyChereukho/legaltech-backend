package ru.hse.legaltech.backend.entity

import jakarta.persistence.*

@Entity
@Table(name = "companies")
data class Company(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "description")
    val description: String?,

    @ManyToOne
    @JoinColumn(name = "category_id")
    val category: Category,

    @Column(name = "year_of_launch")
    val yearOfLaunch: Int?,

    @Column(name = "linkToProject")
    val linkToProject: String?,

    @Column(name = "contacts")
    val contacts: String?,

    @Column(name = "founder")
    val founder: String?,

    @Column(name = "additional_info")
    val additionalInfo: String?,

    /*@OneToOne
    @JoinColumn(name = "image_id")
    val image: CompanyImage*/

    @Column(name = "image_file_name")
    val imageFileName: String?
)