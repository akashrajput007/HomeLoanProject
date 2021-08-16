package com.example.demo.Layer5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public String BASE_UPLOAD_DIR="C:\\Users\\jadhav\\Downloads\\imagesfromrestController";
	
	FileUploadHelper() throws IOException{
		
	}
	
	
		public String uploadFile(MultipartFile multipartFile,Long CustId) {
				
		    String UPLOAD_DIR = BASE_UPLOAD_DIR + File.separator + CustId;
		    File directory = new File(UPLOAD_DIR);
		    if (!directory.exists()) {
		    	directory.mkdir();
		    }

					
			try {
				
				System.out.println(multipartFile.getOriginalFilename());
				
				Files.copy(multipartFile.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
								
				return Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()).toString();
			
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return "cannot insert file";
		}
}
