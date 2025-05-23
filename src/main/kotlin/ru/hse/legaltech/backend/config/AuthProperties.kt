package ru.hse.legaltech.backend.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "auth")
class AuthProperties {
    lateinit var admin: Admin
    lateinit var jwt: Jwt

    class Admin {
        lateinit var username: String
        lateinit var password: String
    }

    class Jwt {
        lateinit var secret: String
    }
}