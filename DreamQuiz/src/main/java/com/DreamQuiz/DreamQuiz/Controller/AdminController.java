package com.DreamQuiz.DreamQuiz.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DreamQuiz.DreamQuiz.entity.Subject;
import com.DreamQuiz.DreamQuiz.entity.Topics;
import com.DreamQuiz.DreamQuiz.serviceimpl.AdminServices;

@Controller

public class AdminController {
	
	
	@Autowired
	AdminServices adminServices;
	
	@RequestMapping("/")
	public String branchLogin(Model model) {
		//System.out.println("manojssss");

		return "admin/sign-in";

	}
	
	@RequestMapping(value="/admin/addsubject",method= RequestMethod.GET)
	public String first() {
		
		System.out.println("hello");
		System.out.println("hello3333");
		return "admin/addsubject";
		//http://localhost:9999/sign-in
	 
	}
	
	@RequestMapping(value="/dashboard",method= RequestMethod.GET)
	public String dashboard() {
		System.out.println("dashboard");


			return "admin/index";
		
		//return "redirect:/admin/sign-in";

	}
	
	@RequestMapping(value="/admin/addnewtopic",method= RequestMethod.GET)
	public String addnewtopic() {
		
		//System.out.println("hello");
		//System.out.println("hello3333");
		return "admin/addnewtopic";
		//http://localhost:9999/sign-in
	 
	}
	
	@RequestMapping(value="/admin/addnewsubtopic",method= RequestMethod.GET)
	public String addnewsubtopic() {
		
		System.out.println("hello");
		System.out.println("hello3333");
		return "admin/addnewsubtopic";
		//http://localhost:9999/sign-in
	 
	}
	
	@RequestMapping(value="/admin/addnewqueation",method= RequestMethod.GET)
	public String addnewqueation() {
		
		System.out.println("hello");
		
		return "admin/addnewqueation";
		//http://localhost:9999/sign-in
	 
	}
	
	
	@RequestMapping(value = "/AdminfindallSubject", method = RequestMethod.GET)
	@ResponseBody
	public List<Subject> findalaSubject() {
		
		
		System.out.println("@ResponseBody table show all subject");
		return adminServices.findalaSubject();
	}
	
	
	@RequestMapping(value="/admin/queationbank",method= RequestMethod.GET)
	public String Subjecttable() {
		
		System.out.println("hello");
		System.out.println("hello3333");
		return "admin/queationbank";
		
	}
	
	
	@RequestMapping(value = "/AdminAddNewSubject", method = RequestMethod.POST)
	@ResponseBody
	public void addNewSubject(Subject subject) {
		System.out.println("hello  \"/AddNewSubject\"   ");
		adminServices.addNewSubject(subject);

	}

	@RequestMapping(value="/admin/showtopicsbysid",method= RequestMethod.GET)
		
	public String showtopictablebysid() {
		
		System.out.println("hello");
		System.out.println("showtopicsbysid method calling");
		return "admin/showtopicsbysid";
		
	}
	
	@RequestMapping(value = "/adminfindTopicsfrimSubject/{sid}", method = RequestMethod.GET)
	@ResponseBody
	public List<Topics> findTopicsbySubjectid(@PathVariable long sid) {
		return adminServices.findTopicsbySubjectid(sid);
	}
	
}
