package ru.hse.legaltech.backend.service

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import ru.hse.legaltech.backend.entity.Company
import ru.hse.legaltech.backend.entity.CompanyImage
import ru.hse.legaltech.backend.repository.CompanyRepository
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

@Service
class CompanyImageService(
    private val companyRepository: CompanyRepository
) {
    private val uploadDir: Path = Paths.get("uploads")

    /*init {
        Files.createDirectories(uploadDir)
    }*/

    fun saveImage(file: MultipartFile, companyId: Int): String {
        val fileName = UUID.randomUUID().toString() + "_" + file.originalFilename
        val filePath = uploadDir.resolve(fileName)
        val imagePath = "/images/$fileName"

        Files.copy(file.inputStream, filePath)

        val company = companyRepository.findById(companyId)
        company.ifPresent {
            val presentCompany = company.get()
            companyRepository.save(
                presentCompany.copy(
                    image = CompanyImage(
                        name = fileName,
                        path = imagePath
                    )
                )
            )
        }

        return imagePath
    }
}