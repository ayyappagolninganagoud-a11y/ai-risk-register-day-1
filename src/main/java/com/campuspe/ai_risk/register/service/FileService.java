package com.campuspe.ai_risk.register.service;

import com.campuspe.ai_risk.register.model.FileData;
import com.campuspe.ai_risk.register.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    private final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

    public FileData uploadFile(MultipartFile file) throws Exception {

        if (file.getSize() > 10 * 1024 * 1024) {
            throw new IllegalArgumentException("File size must be less than 10MB");
        }

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        File dir = new File(UPLOAD_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String filePath = UPLOAD_DIR + fileName;
        file.transferTo(new File(filePath));

        FileData fileData = new FileData();
        fileData.setFileName(fileName);
        fileData.setFileType(file.getContentType());
        fileData.setFilePath(filePath);

        return fileRepository.save(fileData);
    }

    public FileData getFile(Long id) {
        return fileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found"));
    }
}
