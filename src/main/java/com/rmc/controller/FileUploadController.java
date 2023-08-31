package com.rmc.controller;
import java.io.File;
import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import cn.hutool.http.HttpStatus;
@Controller
public class FileUploadController {
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("folderName") String folderName) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload.");
        }
        String uploadDir = "C:\\Users\\009740672\\Box\\2023 JAVA模拟\\";
        File targetDirectory = new File(uploadDir, folderName);
        if (!targetDirectory.exists()) {
            boolean created = targetDirectory.mkdirs();
            if (!created) {
                return ResponseEntity.status(HttpStatus.HTTP_INTERNAL_ERROR).body("Failed to create target directory.");
            }
        }
        String fileName = file.getOriginalFilename();
        File targetFile = new File(targetDirectory, fileName);
        try {
            file.transferTo(targetFile);
            return ResponseEntity.ok("File uploaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.HTTP_INTERNAL_ERROR).body("An error occurred during file upload.");
        }
    }
}