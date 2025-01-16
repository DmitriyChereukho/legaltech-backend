package ru.hse.legaltech.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LegaltechBackendApplication

fun main(args: Array<String>) {
    runApplication<LegaltechBackendApplication>(*args)
}
