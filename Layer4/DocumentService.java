package com.example.demo.Layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Customer;
import com.example.demo.Layer2.Document;


@Service
public interface DocumentService {
	public void insertDocumentService(Document doc, Customer customer);
	//public void insertDocumentService(Document doc);
	public Document selectDocumentService(Long custId);
	public List<Document> selectAllDocumentService();
}
