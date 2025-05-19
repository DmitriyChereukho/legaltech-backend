package ru.hse.legaltech.backend.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers(HttpMethod.POST, "/requests").permitAll()
                    .requestMatchers(HttpMethod.POST, "/requests/update").permitAll()
                    .requestMatchers(HttpMethod.GET, "/requests").authenticated()
                    .requestMatchers(HttpMethod.GET).permitAll()
                    .requestMatchers(HttpMethod.OPTIONS).permitAll()
                    .anyRequest().authenticated()
            }
            .httpBasic { }
            .csrf { it.disable() }

        return http.build()
    }
}