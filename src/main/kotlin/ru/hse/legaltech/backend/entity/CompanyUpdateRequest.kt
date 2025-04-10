package ru.hse.legaltech.backend.entity

import jakarta.persistence.*
import lombok.Builder
import lombok.Data
import org.hibernate.annotations.CreationTimestamp
import ru.hse.legaltech.backend.enum.RequestStatus
import java.time.LocalDateTime

@Entity
@Data
@Table(name = "update_requests")
@Builder
data class CompanyUpdateRequest(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int? = null,

    @Column(name = "name")
    val name: String,

    @ManyToOne
    @JoinColumn(name = "company_id")
    val company: Company,

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
    val additionalInfo: String?,

    /*@OneToOne
    @JoinColumn(name = "image_id")
    val image: CompanyImage*/

    @Column(name = "image_file_name")
    val imageFileName: String?,

    @CreationTimestamp
    @Column(nullable = false, updatable = false, name = "created_at")
    val createdAt: LocalDateTime,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "status")
    val status: RequestStatus
)