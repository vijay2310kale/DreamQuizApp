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
	
	String uploadProductDirectory = System.getProperty("user.dir") + "/uploads/";
	
	
	@RequestMapping("/uploads")
	
	public String geBooktProductImage(@PathVariable("queationImage") String queationImage, HttpServletResponse response) {
		try {
			byte b[] = Files.readAllBytes(Paths.get(uploadProductDirectory + queationImage));
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


}
