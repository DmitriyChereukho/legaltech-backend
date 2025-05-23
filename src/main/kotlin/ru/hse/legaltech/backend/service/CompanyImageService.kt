package ru.hse.legaltech.backend.service

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

@Service
class CompanyImageService {

    private val uploadDirectory = "/mnt/uploads"

    fun saveImage(file: MultipartFile): String {
        val targetLocation: Path = Paths.get(uploadDirectory, file.originalFilename!!)

        if (Files.exists(targetLocation)) {
            return file.originalFilename!!
        }

        file.inputStream.use { inputStream ->
            Files.copy(inputStream, targetLocation)
        }

        return file.originalFilename!!
    }

    fun deleteImage(fileName: String): Boolean {
        val targetLocation: Path = Paths.get(uploadDirectory, fileName)

        return try {
            Files.deleteIfExists(targetLocation)
        } catch (_: Exception){
            false
        }
    }
}