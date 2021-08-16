package com.example.demo.Layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Layer2.Document;

@Repository
public interface DocumentRepository {
  public void insertDocument(Document doc);
  public Document selectDocument(Long custId);
  public List<Document> selectAllDocument();
}
