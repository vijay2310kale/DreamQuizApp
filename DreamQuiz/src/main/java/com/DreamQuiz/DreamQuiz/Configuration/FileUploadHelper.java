package com.DreamQuiz.DreamQuiz.Configuration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.catalina.core.NamingContextListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	
	//public static  String UPLOAD_DIR="C:\\Users\\Dell\\git\\Spring2310Boot\\DreamQuiz\\src\\main\\resources\\static\\pdffiles";
	
	
	
	 public FileUploadHelper() throws IOException
	 {
		
		 
	 }
	
	
	public static boolean uploadFile(MultipartFile multipartFile) throws IOException{
		
	
		 System.out.println("FileUploadHelper");
		 File UPLOAD_DIR=new ClassPathResource("/static/pdffiles/").getFile().getAbsoluteFile();
	     // String UPLOAD_DIR="http://167.172.148.60:/home/dreamquiz/";
		// String UPLOAD_DIR = "F://DQFiles/";
	//String UPLOAD_DIR="http://dreamquizs.com/dreamquizpdffiles/";
		 
		// String UPLOAD_DIR= http://prismitservice.com/Vijay/
    	 boolean f=false;
    	 
    	 
    	 try {
    		 
    		 
//    		 InputStream is= multipartFile.getInputStream();
//    		 byte data[]= new byte[is.available()];
//    		 
//    		 is.read(data);
//    		 
//    		
//    		 FileOutputStream fos= new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
//    		 
//    		 fos.write(data);
//    		 
//    		 fos.close();
//    		 fos.flush();
//    		 	http://localhost:8081/uploads/202201281243-whatsapp-image-2021-11-01-at-10.35.20-pm.jpeg
    		//  '<td>'+'<img src="'+'/uploads/pro/'+data[i].image+'" height="80px;" width="80px;">'+
    		 
    	Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
    		 
    		 
    		 f=true;
    		 System.out.println("value of f is :::"+f);
    	 }
    	 catch(Exception e) {
    		 e.printStackTrace();
    	 }
		return f;
    	 
     } 



}
