package ru.hse.legaltech.backend.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    @RequestMapping("/test")
    fun getInfo(): String {
        return
    }
}