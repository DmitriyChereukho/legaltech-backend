package ru.hse.legaltech.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Builder
import lombok.Data
import java.util.*

@Entity
@Data
@Table(name = "requests")
@Builder
class Request(
    @Id
    @Column(name = "id")
    private val id: UUID,

    private val description: String
)