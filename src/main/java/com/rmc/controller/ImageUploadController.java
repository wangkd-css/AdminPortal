package com.rmc.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
@RestController
public class ImageUploadController {
    @PostMapping("/upload")
    public Map<String, Object> uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
        Map<String, Object> response = new HashMap<>();
        if (!imageFile.isEmpty()) {
            try {
                // Specify the path where you want to save the uploaded image
                String uploadPath = "C:\\Users\\221345672\\Box\\2023 JAVA模拟\\";
                // Create the upload directory if it doesn't exist
                Files.createDirectories(Paths.get(uploadPath));
                // Save the image to the specified path
                byte[] bytes = imageFile.getBytes();
                Path filePath = Paths.get(uploadPath + imageFile.getOriginalFilename());
                Files.write(filePath, bytes);
                response.put("success", true);
            } catch (IOException e) {
                e.printStackTrace();
                response.put("success", false);
            }
        } else {
            response.put("success", false);
        }
        return response;
    }
}