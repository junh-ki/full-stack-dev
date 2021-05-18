package com.jun.document.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.document.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
