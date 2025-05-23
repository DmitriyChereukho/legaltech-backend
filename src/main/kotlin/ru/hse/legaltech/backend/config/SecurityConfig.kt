package ru.hse.legaltech.backend.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import ru.hse.legaltech.backend.jwt.JwtFilter


@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun securityFilterChain(http: HttpSecurity, jwtFilter: JwtFilter): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .authorizeHttpRequests {
                it.requestMatchers("/auth/login").permitAll()
                    .requestMatchers(HttpMethod.POST, "/requests").permitAll()
                    .requestMatchers(HttpMethod.POST, "/requests/update").permitAll()
                    .requestMatchers(HttpMethod.GET, "/requests").authenticated()
                    .requestMatchers(HttpMethod.GET).permitAll()
                    .requestMatchers(HttpMethod.OPTIONS).permitAll()
                    .anyRequest().authenticated()
            }
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }
}