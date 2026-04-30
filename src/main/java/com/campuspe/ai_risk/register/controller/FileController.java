package com.campuspe.ai_risk.register.controller;

import com.campuspe.ai_risk.register.model.FileData;
import com.campuspe.ai_risk.register.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    // Upload file
    @PostMapping("/upload")
    public FileData uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        return fileService.uploadFile(file);
    }

    // Get file by ID
    @GetMapping("/{id}")
    public FileData getFile(@PathVariable Long id) {
        return fileService.getFile(id);
    }
}