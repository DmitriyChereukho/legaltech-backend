package ru.hse.legaltech.backend.jwt

import io.jsonwebtoken.Jwts
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import ru.hse.legaltech.backend.config.AuthProperties

@Component
class JwtFilter(private val authProperties: AuthProperties) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        val authHeader = request.getHeader("Authorization")
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            val token = authHeader.removePrefix("Bearer ").trim()
            try {
                val claims = Jwts.parserBuilder()
                    .setSigningKey(authProperties.jwt.secret.toByteArray())
                    .build()
                    .parseClaimsJws(token)

                val username = claims.body.subject
                val auth =
                    UsernamePasswordAuthenticationToken(username, null, listOf(SimpleGrantedAuthority("ROLE_ADMIN")))
                SecurityContextHolder.getContext().authentication = auth
            } catch (ex: Exception) {
                response.status = HttpServletResponse.SC_UNAUTHORIZED
                return
            }
        }

        filterChain.doFilter(request, response)
    }
}