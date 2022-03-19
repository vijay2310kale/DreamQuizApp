package com.DreamQuiz.DreamQuiz.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImageReadController {
	
	
//	String uploadProductDirectory ="http://prismitservice.com/Vijay/";
	String uploadProductDirectory = System.getProperty("user.dir") + "/DMImages/images/";

	String allpdffiles = System.getProperty("user.dir") + "/pdffils/allpdffiles/";
	
	/*
	 * @RequestMapping("/uploads/images/{queationImage}") public String
	 * geBooktProductImage(@PathVariable("queationImage") String queationImage,
	 * HttpServletResponse response) { try { byte b[] =
	 * Files.readAllBytes (Paths.get(uploadProductDirectory + queationImage));
	 * response.setContentLength(b.length); response.setContentType("image/jpg");
	 * ServletOutputStream os = response.getOutputStream(); os.write(b); os.flush();
	 * } catch (IOException e) { e.printStackTrace(); } return null;
	 * 
	 * }
	 */
	
	@RequestMapping("/DMImages/images/{files}")
	public String getBannerImage(@PathVariable("files") String files, HttpServletResponse response) {
		try {
			byte b[] = Files.readAllBytes(Paths.get(uploadProductDirectory + files));
			response.setContentLength(b.length);
			response.setContentType("image/jpg");
			ServletOutputStream os = response.getOutputStream();
			os.write(b);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping("/pdffils/allpdffiles/{files}")
	public String getpdf(@PathVariable("files") String files, HttpServletResponse response) {
		try {
			
			
			System.out.println("  vijay 1 ");
			byte b[] = Files.readAllBytes(Paths.get(allpdffiles + files));
			response.setContentLength(b.length);
			System.out.println("  vijay 2 ");
			response.setContentType("application/pdf");
			ServletOutputStream os = response.getOutputStream();
			os.write(b);
			os.flush();
			System.out.println("  vijay 3 ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}


}
