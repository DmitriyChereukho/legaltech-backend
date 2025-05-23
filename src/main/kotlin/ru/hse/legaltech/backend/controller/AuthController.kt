package ru.hse.legaltech.backend.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.hse.legaltech.backend.config.AuthProperties
import ru.hse.legaltech.backend.model.JwtResponse
import ru.hse.legaltech.backend.model.LoginRequest
import ru.hse.legaltech.backend.utils.JwtService

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authProperties: AuthProperties,
    private val jwtService: JwtService,
) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<JwtResponse> {
        return if (request.username == authProperties.admin.username && request.password == authProperties.admin.password) {
            val token = jwtService.generateToken(request.username)
            ResponseEntity.ok(JwtResponse(token))
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
    }
}