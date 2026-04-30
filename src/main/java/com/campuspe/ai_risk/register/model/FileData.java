package com.campuspe.ai_risk.register.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String fileType;
    private String filePath;
}