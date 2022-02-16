package com.DreamQuiz.DreamQuiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class DreamQuiz {
	
	
	@RequestMapping(value ="/test", method = RequestMethod.GET)
	@ResponseBody
		public String testing() {
		System.out.println("hello dreamquiz");
		return  "redirect:admin/image";
		
	}
	

	public static void main(String[] args) {
		SpringApplication.run(DreamQuiz.class, args);
	}

}
