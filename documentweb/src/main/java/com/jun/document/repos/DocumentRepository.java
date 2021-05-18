package com.jun.document.repos;

import org.springframework.data.repository.CrudRepository;

import com.jun.document.entities.Document;

public interface DocumentRepository extends CrudRepository<Document, Long> {

}
