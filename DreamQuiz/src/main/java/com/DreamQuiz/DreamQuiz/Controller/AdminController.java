package com.DreamQuiz.DreamQuiz.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.DreamQuiz.DreamQuiz.Repository.CurrentAfairsRepository;
import com.DreamQuiz.DreamQuiz.entity.AppJsopnResponse;
import com.DreamQuiz.DreamQuiz.entity.CurrentAffairs;
import com.DreamQuiz.DreamQuiz.entity.Examdetails;
import com.DreamQuiz.DreamQuiz.entity.OldPaper;
import com.DreamQuiz.DreamQuiz.entity.Subject;
import com.DreamQuiz.DreamQuiz.entity.Topics;
import com.DreamQuiz.DreamQuiz.entity.Videodetails;
import com.DreamQuiz.DreamQuiz.serviceimpl.AddQuestionServiceImpl;
import com.DreamQuiz.DreamQuiz.serviceimpl.AdminServices;

@Controller

public class AdminController {
	
	
	@Autowired
	AdminServices adminServices;
	
	@Autowired
	AddQuestionServiceImpl addQuestionService;
	
	
String uploadProductDirectory = System.getProperty("user.dir") + "/DMImages/images/";
	
	String allpdffiles = System.getProperty("user.dir") + "/pdffils/allpdffiles/";
	String serverip="http://3.7.163.87:9999";
	
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
	
	
	
	@RequestMapping(value="/admin/addnewoldpaper",method= RequestMethod.GET)
	public String addnewoldpaper() {
		
		System.out.println("hello");
		
		return "admin/addoldpaper";
		//http://localhost:9999/sign-in
	 
	}
	
	
	@RequestMapping(value = "/Adminfindalloldpaper", method = RequestMethod.GET)
	@ResponseBody
	public List<OldPaper> Adminfindalloldpaper() {
		
		
		System.out.println("@ResponseBody table show all old paper");
		return adminServices.Adminfindalloldpaper();
	}
	
	
	  @RequestMapping(value = "/AddNewoldpaperpdf", method = RequestMethod.POST)
	  
	  	public AppJsopnResponse saveBanner(OldPaper oldpaper,BindingResult bindingResult,@RequestParam("thumbnail") MultipartFile thumbnail,@RequestParam("oppdffile") MultipartFile oppdffile, HttpSession session) {
	  	
	    	  File f = new File(allpdffiles);
				if (!f.exists()) {
					f.mkdirs();
				}
				File f2 = new File(uploadProductDirectory);
				if (!f2.exists()) {
					f2.mkdirs();
				}
				
				if (!oppdffile.isEmpty()) {
	  			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
	  			String originalFileName = dateName + "-"
	  					+ oppdffile.getOriginalFilename().replace(" ", "-").toLowerCase();
	  			Path fileNameAndPath = Paths.get(allpdffiles, originalFileName);
	  			System.out.println("file name path "+ fileNameAndPath);
	  			
	  			String path=serverip+"/pdffils/allpdffiles/"+originalFileName;
	  			try {
	  				Files.write(fileNameAndPath, oppdffile.getBytes());
	  			} catch (IOException e) {
	  				e.printStackTrace();
	  			}
	  			String filepath=fileNameAndPath.toString();
	  			 oldpaper.setOppdffile(path);
	  			 System.out.println("check path  "+filepath);
	  			
	  			
	  		}
	    	  
	    	  else {
	  			
	  			 oldpaper.setOppdffile("");
	  		}
				
				if (!thumbnail.isEmpty()) {
		  			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		  			String originalFileName = dateName + "-"
		  					+ thumbnail.getOriginalFilename().replace(" ", "-").toLowerCase();
		  			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
		  			System.out.println("file name path "+ fileNameAndPath);
		  			
		  			String path=serverip+"/DMImages/images/"+originalFileName;
		  			try {
		  				Files.write(fileNameAndPath, thumbnail.getBytes());
		  			} catch (IOException e) {
		  				e.printStackTrace();
		  			}
		  			String filepath=fileNameAndPath.toString();
		  			
		  			oldpaper.setThumbnail(path);
		  		}
		    	  
		    	  
		    	  
		    	  else {
		  			
		    		  oldpaper.setThumbnail("");
		  		}
				
	    	  
	    	  addQuestionService.addnewoldpaperpdf(oldpaper);
			return null;
	    	  
	    	  
	    	  
//	  		AppJsopnResponse resp = new AppJsopnResponse();
//	  		
//	  	     resp.setMessage("file save in db...");
//	  		resp.setStatus("True");
//	  		resp.setData("");
//	  		return resp;
	  	}  
	    
	  
	  @RequestMapping(value="/admin/addnewexampage",method= RequestMethod.GET)
		public String addnewexam() {
			
			System.out.println("hello");
			
			return "admin/addnewexam";
			
		 
		}

	  @RequestMapping(value = "/findallexamdetails", method = RequestMethod.GET)
		@ResponseBody
		public List<Examdetails> Addnewexamdetails() {
			
			
			System.out.println("@ResponseBody table show all old paper");
			return adminServices.Addnewexamdetails();
		}
	
	  
	  
	 
	  
	  @RequestMapping(value = "/adminAddNewExamDetails", method = RequestMethod.POST)
		public AppJsopnResponse AddNewExamDetails(Examdetails examdetails) {
			
			AppJsopnResponse resp = new AppJsopnResponse();
			try {
				String examnamebyuser=examdetails.getExamname();
				System.out.println("subject name "+examnamebyuser);
				List<String>examnamefromdb = addQuestionService.examnamefromdb();
				System.out.println("size of subject list "+examnamefromdb.size());
				if(examnamefromdb.contains(examnamebyuser))
				{
					
					
					resp.setMessage("Exam Name Allready exits ");
					resp.setStatus("0");
				
					
				}
				
				else {
					
					
					
					 long time = System.currentTimeMillis();
				  		java.sql.Timestamp date = new java.sql.Timestamp(time);
				  		String datetimespan=String.valueOf(date);
				  		
				  		examdetails.getDatetimespan();
					addQuestionService.AddExamdetails(examdetails);
					System.out.println("Examdetails save success");
					
					resp.setMessage("Examdetails save ");
					resp.setStatus("1");
					
				}
			

		}
		catch(Exception e) {

			e.printStackTrace();
		}
			return resp;

}

	  
	  @RequestMapping(value="/admin/addNewVideoPage",method= RequestMethod.GET)
		public String addnewvideopage() {
			
			System.out.println("hello");
			
			return "admin/newvideodata";
			
		 
		}

	  @RequestMapping(value = "/findallvideodetails", method = RequestMethod.GET)
		@ResponseBody
		public List<Videodetails> findallvideodetails() {
			
			
			System.out.println("@ResponseBody table show all old paper");
			return adminServices.findallvideodetails();
		}
	  
	  
		@RequestMapping(value = "/adminAddNewVideodetails", method = RequestMethod.POST)
		public AppJsopnResponse AddNewVideodetails(Videodetails videodetails) {
			
			AppJsopnResponse resp = new AppJsopnResponse();
			try {
				String videptilebyuser=videodetails.getVtitle();
				System.out.println("subject name "+videptilebyuser);
				List<String> videotitlefromdb = addQuestionService.videotitlefromdb();
				System.out.println("size of subject list "+videotitlefromdb.size());
				if(videotitlefromdb.contains(videptilebyuser))
				{
					
					
					resp.setMessage("video title Allready exits ");
					resp.setStatus("0");
					System.out.println("video title");
				
				}
				
				else {
					
					 long time = System.currentTimeMillis();
				  		java.sql.Timestamp date = new java.sql.Timestamp(time);
				  		String datetimespan=String.valueOf(date);
				  		videodetails.setVpostdate(datetimespan);
					
					addQuestionService.AddNewVideodetails(videodetails);
					System.out.println(" video details save success");
					
					resp.setMessage("video details save ");
					resp.setStatus("1");
				
				}
			

		}
		catch(Exception e) {

			e.printStackTrace();
		}
			return resp;

}
		
		
		 @RequestMapping(value="/admin/getcapdfPage",method= RequestMethod.GET)
			public String getcapdfPage() {
				
				System.out.println("hello");
				
				return "admin/addnewcapdf";
				
			 
			}
		 
		 
		 @RequestMapping(value = "/adminfindallCADetails", method = RequestMethod.GET)
			@ResponseBody
			public List<CurrentAffairs> adminfindallCADetails() {
				
				
				System.out.println("@ResponseBody table show all old paper");
				return adminServices.adminfindallCADetails();
			}
		 
		 
		 @RequestMapping(value = "/adminaddcfpdf", method = RequestMethod.POST)

			public AppJsopnResponse addcfpdf(CurrentAffairs curentafairs,BindingResult bindingResult,@RequestParam("pdffile") MultipartFile pdffile,@RequestParam("thumbnail") MultipartFile thumbnail, HttpSession session) {
			  	
		  	  File f = new File(allpdffiles);
					if (!f.exists()) {
						f.mkdirs();
					}

					File f2 = new File(uploadProductDirectory);
					if (!f2.exists()) {
						f2.mkdirs();
					}

				System.out.println(" pdf type   : "+pdffile.getContentType());
				System.out.println(" pdf type   : "+thumbnail.getContentType());
				
				String cfpdftitlefrmuser=curentafairs.getTitle();
			
				System.out.println(" pdf name from user : "+cfpdftitlefrmuser);
				List<String> catitlefrmdb=addQuestionService.findallcrpdftitle();
				System.out.println(" pdf name listsize user : "+catitlefrmdb);
				
				if(catitlefrmdb.contains(cfpdftitlefrmuser)) {
				
					AppJsopnResponse resp = new AppJsopnResponse();
					resp.setMessage("file  Allready exits ");
					//resp.setStatus("True");
					System.out.println("not save file");
					return resp;
					
				}  
				else {
					
					 if (!pdffile.isEmpty()) {
				  			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				  			String originalFileName = dateName + "-"
				  					+ pdffile.getOriginalFilename().replace(" ", "-").toLowerCase();
				  			Path fileNameAndPath = Paths.get(allpdffiles, originalFileName);
				  			System.out.println("file name path "+ fileNameAndPath);
				  			String path=serverip+"/pdffils/allpdffiles/"+originalFileName;
				  			System.out.println("allpdffiles    "+ path);
				  			try {
				  				Files.write(fileNameAndPath, pdffile.getBytes());
				  			} catch (IOException e) {
				  				e.printStackTrace();
				  			}
				  			String filepath=fileNameAndPath.toString();
				  		
						
							 curentafairs.setPdffile(path);
						
						
					}
					 
					 if (!thumbnail.isEmpty()) {
				  			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				  			String originalFileName = dateName + "-"
				  					+ thumbnail.getOriginalFilename().replace(" ", "-").toLowerCase();
				  			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				  			System.out.println("file name path "+ fileNameAndPath);
				  			String path=serverip+"/DMImages/images/"+originalFileName;
				  			
				  			System.out.println("allpdffiles   2 "+ path);
				  			try {
				  				Files.write(fileNameAndPath, thumbnail.getBytes());
				  			} catch (IOException e) {
				  				e.printStackTrace();
				  			}
				  			String filepath=fileNameAndPath.toString();
				  		
						
							 
							 curentafairs.setThumbnail(path);
						
					}
					
				}
							
				addQuestionService.addnewcapdf(curentafairs);
				
				AppJsopnResponse resp = new AppJsopnResponse();
				resp.setMessage("Save pdf file  success ");
			    resp.setStatus("True");
				System.out.println("success save pdf file");
				
				return resp;
				}



}
