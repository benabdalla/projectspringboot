package com.blue.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
@RestController
@CrossOrigin("*")
public class FileuploaddemoApplication {

	
	@RequestMapping(value="/upload", method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		File convertFile = new File("C:\\Users\\ASUS\\back\\src\\assets\\images\\"+file.getOriginalFilename());
		File convertFile2 = new File("C:\\Users\\ASUS\\livreur\\src\\assets\\images\\"+file.getOriginalFilename());
		convertFile.createNewFile();
		convertFile2.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		FileOutputStream fout2 = new FileOutputStream(convertFile2);
		fout.write(file.getBytes());
		fout2.write(file.getBytes());
		fout.close();
		fout2.close();
		return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
	}
}