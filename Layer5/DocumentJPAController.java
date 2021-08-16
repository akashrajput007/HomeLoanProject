package com.example.demo.Layer5;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Layer2.Customer;
import com.example.demo.Layer2.Document;
import com.example.demo.Layer4.DocumentServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/doc")
public class DocumentJPAController {
  
	@Autowired
	DocumentServiceImpl documentService;

	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/addDocument")
	public void addDocument(Document doc, Customer cust) {
		System.out.println("add Document Controller called");
		documentService.insertDocumentService(doc, cust);
	}
	
	@GetMapping("/getDocument/{custId}")
	public Document getDocument(@PathVariable Long custId) {
		System.out.println("Get Document Controller callled");
		return documentService.selectDocumentService(custId);
	}
	
	@PostMapping("/upload-file/{CustId}")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable Long CustId) {
			
		try {
			String path = fileUploadHelper.uploadFile(file, CustId);
			
			if(path!="cannot insert file") {
				return new ResponseEntity<String>(path, HttpStatus.OK);
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong! Try again!!");
	}
	
	
}
