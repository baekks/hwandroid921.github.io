package com.tour.jeju.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class FileConfig {

    @Value("${file.upload-dir}")
    public String uploadDir;

    @PostConstruct
    public void init() throws IOException {
        Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
        Files.createDirectories(uploadPath);
        uploadDir = uploadPath.toString() + File.separator;
    }
}
