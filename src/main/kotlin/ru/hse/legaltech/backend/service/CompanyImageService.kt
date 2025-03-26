package ru.hse.legaltech.backend.service

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

@Service
class CompanyImageService {

    fun saveImage(file: MultipartFile): String {
        val uploadDirectory = "/mnt/uploads"
        val targetLocation: Path = Paths.get(uploadDirectory, file.originalFilename!!)

        // Проверяем, существует ли файл
        if (Files.exists(targetLocation)) {
            return file.originalFilename!! // Файл уже существует, ничего не делаем
        }

        // Если файл не существует, сохраняем его
        file.inputStream.use { inputStream ->
            Files.copy(inputStream, targetLocation)
        }

        return file.originalFilename!!
    }
}