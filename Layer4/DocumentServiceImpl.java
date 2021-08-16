package com.example.demo.Layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Customer;
import com.example.demo.Layer2.Document;

import com.example.demo.Layer3.DocumentRepositoryImpl;

@Service
public class DocumentServiceImpl implements DocumentService {
	@Autowired
	DocumentRepositoryImpl documentRepo;
	
	@Override
	public void insertDocumentService(Document doc, Customer customer) {
		doc.setCustomer(customer);
		documentRepo.insertDocument(doc);	
	}

	
	@Override
	public Document selectDocumentService(Long custId) {
		return documentRepo.selectDocument(custId);
	}
	
	@Override
    public List<Document> selectAllDocumentService() {
        return documentRepo.selectAllDocument();
    }

}
