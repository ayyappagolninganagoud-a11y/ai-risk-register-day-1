package com.campuspe.ai_risk.register.repository;

import com.campuspe.ai_risk.register.model.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileData, Long> {
}