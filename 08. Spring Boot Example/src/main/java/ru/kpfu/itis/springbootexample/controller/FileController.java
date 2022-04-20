package ru.kpfu.itis.springbootexample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
public class FileController {

    private Logger logger = LoggerFactory.getLogger(FileController.class);

    @Value("${custom.file.storage}")
    private String filePath;

    @PostMapping(value = "/files")
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file) {
        logger.info("Загружаем файл");
        String fileName = file.getOriginalFilename();
        try {
            file.transferTo(new File(filePath + fileName));
        } catch (IOException e) {
            logger.error("Произошла ошибка во время загрузки файла");
            return ResponseEntity.internalServerError().build();
        }
        logger.info("Файл успешно загружен");
        return ResponseEntity.ok("The file was successfully uploaded");
    }

    @GetMapping("/photo/{filename:.+}")
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        File file = new File(filePath + filename);
        try {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            logger.info("Отправляем файл {}", filename);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(file.length())
                    .body(resource);
        } catch (FileNotFoundException e) {
            logger.error("Файл {} не найден", filename);
            return ResponseEntity.badRequest().build();
        }
    }


}
