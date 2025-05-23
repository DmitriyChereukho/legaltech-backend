package ru.hse.legaltech.backend.utils

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import ru.hse.legaltech.backend.config.AuthProperties
import java.util.*

@Service
class JwtService(
    private val authProperties: AuthProperties,
) {
    fun generateToken(username: String): String {
        val expiration = Date(System.currentTimeMillis() + 1000 * 60 * 60 * 3)
        return Jwts.builder()
            .setSubject(username)
            .setExpiration(expiration)
            .signWith(Keys.hmacShaKeyFor(authProperties.jwt.secret.toByteArray()), SignatureAlgorithm.HS256)
            .compact()
    }
}