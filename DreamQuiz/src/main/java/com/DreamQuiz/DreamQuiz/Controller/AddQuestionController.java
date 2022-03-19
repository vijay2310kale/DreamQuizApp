package com.DreamQuiz.DreamQuiz.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.DreamQuiz.DreamQuiz.AndroidRespopnce.NewRegiRepo;
import com.DreamQuiz.DreamQuiz.Configuration.FileUploadHelper;
import com.DreamQuiz.DreamQuiz.Configuration.OTPServerMsg91;
import com.DreamQuiz.DreamQuiz.entity.AppJsopnResponse;
import com.DreamQuiz.DreamQuiz.entity.CurrentAffairs;
//import com.DreamQuiz.DreamQuiz.entity.Doc;
import com.DreamQuiz.DreamQuiz.entity.Examdetails;
import com.DreamQuiz.DreamQuiz.entity.NewRegister;
//import com.DreamQuiz.DreamQuiz.entity.FileDB;
import com.DreamQuiz.DreamQuiz.entity.OldPaper;
import com.DreamQuiz.DreamQuiz.entity.Queations;
import com.DreamQuiz.DreamQuiz.entity.SubTopics;
import com.DreamQuiz.DreamQuiz.entity.Subject;
import com.DreamQuiz.DreamQuiz.entity.Topics;
import com.DreamQuiz.DreamQuiz.entity.Topicsnotespdf;
import com.DreamQuiz.DreamQuiz.entity.Videodetails;
import com.DreamQuiz.DreamQuiz.serviceimpl.AddQuestionServiceImpl;




@RestController

public class AddQuestionController {

	private static final ResponseEntity<String> ResponceEntity = null;

	@Autowired
	AddQuestionServiceImpl addQuestionService;
	@Autowired
	FileUploadHelper fileUploadHelper;
	
	String uploadProductDirectory = System.getProperty("user.dir") + "/DMImages/images/";
	
	String allpdffiles = System.getProperty("user.dir") + "/pdffils/allpdffiles/";
	String serverip="http://3.7.163.87:9999";
	
	@RequestMapping(value ="/images")
		public String testing() {
		System.out.println("hello dreamquiz");
		return  "admin/image";
		
	}
	
	@RequestMapping(value = "/AddNewSubject", method = RequestMethod.POST)

	public AppJsopnResponse addNewSubject(Subject subject,BindingResult bindingResult,@RequestParam("thumbnail") MultipartFile thumbnail,HttpSession session) {
		
		System.out.println("hello  \"/AddNewSubject\"   ");
		
			String subName=subject.getSubjectName();
			
			System.out.println("subject name "+subName);
			List<String> subjectfromdb = addQuestionService.getallsubject();
			System.out.println("size of subject list "+subjectfromdb.size());
			if(subjectfromdb.contains(subName))
			{
				
				AppJsopnResponse resp = new AppJsopnResponse();
				resp.setMessage("Subject Allready exits ");
				resp.setStatus("True");
				System.out.println("not save subject");
				return resp;
			}
			
			else {
				
				
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
		  			
		  			
		  			subject.setThumbnail(path);
		  		}
		    	  
		    	  else {
		  			
		    		  subject.setThumbnail("");
		  		}

				addQuestionService.addNewSubject(subject);
				System.out.println(" save subject success");
				AppJsopnResponse resp = new AppJsopnResponse();
				resp.setMessage("Queation save ");
				resp.setStatus("True");
				return resp;
			}
		

	}

	private void selectallsubject() {
		// TODO Auto-generated method stub
		
	}

	@RequestMapping(value = "/AddTopic", method = RequestMethod.POST)

	public AppJsopnResponse addnewtopic(Topics topics,BindingResult bindingResult,@RequestParam("thumbnail") MultipartFile thumbnail,HttpSession session) {
		
		
		String topicfromuser=topics.getTopicname();
		long sid=topics.getSid();
		
		System.out.println(" topic name from user : "+topicfromuser);
		
		List<String> topicfromdb=addQuestionService.getAllTpoicfromdb(sid);
		System.out.println("size of subject list "+topicfromdb.size());
		if(topicfromdb.contains(topicfromuser)) {
			
			AppJsopnResponse resp = new AppJsopnResponse();
			resp.setMessage("Topic Allready exits ");
			resp.setStatus("True");
			System.out.println("not save topic");
			return resp;
		}
		else {	
			
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
	  			
	  			
	  			topics.setThumbnail(path);
	  		}
	    	  
	    	  else {
	  			
	    		  topics.setThumbnail("");
	  		}


			addQuestionService.addnewtopic(topics);
			
			AppJsopnResponse resp = new AppJsopnResponse();
			resp.setMessage("Save Topic  success ");
			resp.setStatus("True");
			System.out.println("success save topic");
			
			return resp;
		}
	
		}

	

	@RequestMapping(value = "/AddsubTopic", method = RequestMethod.POST)

	public AppJsopnResponse addnewsubtopic(SubTopics subTopics) {
		
		
		String Subtopicfromuser=subTopics.getSubtopicname();
		long tid=subTopics.getTid();
		System.out.println(" SubTopic name from user : "+Subtopicfromuser);
		List<String> subtopicfromdb=addQuestionService.findsubtopicfromdb(tid);
		System.out.println(" SubTopic name listsize user : "+subtopicfromdb);
		
		if(subtopicfromdb.contains(Subtopicfromuser)) {
			AppJsopnResponse resp = new AppJsopnResponse();
			resp.setMessage("SubTopic Allready exits ");
			resp.setStatus("True");
			System.out.println("not save SubTopic");
			return resp;
			
		}
		else {		
		addQuestionService.addnewsubtopic(subTopics);
		
		AppJsopnResponse resp = new AppJsopnResponse();
		resp.setMessage("Save SubTopic  success ");
		resp.setStatus("True");
		System.out.println("success save SubTopic");
		
		return resp;
		}

	}

	

	@RequestMapping(value = "/findallSubject", method = RequestMethod.GET)
	public List<Subject> findalaSubject() {
		return addQuestionService.getstudent();
		
		
	}

	

	
	@RequestMapping(value = "/findQueationBysubTopicId/{stid}", method = RequestMethod.GET)

	public List<Queations> getQueationbysubtopicid(@PathVariable Long stid) {
		System.out.println("check Id" + stid);

		return addQuestionService.getBysubtopicid(stid);

	}

	
	@RequestMapping(value = "/findTopicbysid/{sid}", method = RequestMethod.GET)

	public List<Topics> getTopicbysid(@PathVariable Long sid) {
		System.out.println("check Id" + sid);

		return addQuestionService.getTopicbysid(sid);

	}


	
	@RequestMapping(value = "/findSubTopicbytid/{tid}", method = RequestMethod.GET)
	public List<SubTopics> getSubTopicsbytid(@PathVariable Long tid){
		return addQuestionService.getSubTopicsbytid(tid);
		
	}
	
	
	

	@RequestMapping(value = "/save-newQueation", method = RequestMethod.POST)
	@ResponseBody
	public AppJsopnResponse saveNewQueation(Queations queations,BindingResult bindingResult,
			@RequestParam("imgQeation") MultipartFile imgQeation,
			@RequestParam("imgOptionA") MultipartFile imgOptionA,
			@RequestParam("imgOptionB") MultipartFile imgOptionB,
			@RequestParam("imgOptionC") MultipartFile imgOptionC,
			@RequestParam("imgOptionD") MultipartFile imgOptionD,HttpSession session) throws IOException {
		
		
		
		//long qid=	queations.getQid();
		long lastprimaryid= addQuestionService.getlastinsertpid();
		System.out.println("lastprimaryid "+lastprimaryid);
		long plusone_lastprimaryid=lastprimaryid+1;
		System.out.println("plusone_lastprimaryid  "+plusone_lastprimaryid);
		String s_=String.valueOf(plusone_lastprimaryid);
		
		System.out.println("plusone_lastprimaryid String "+ s_);
		
		
	//	String path = "/var/lib/tomcat8/webapps/Files/";
	// String path = "F://DQImages/";
	//String path= "167.172.148.60:/home/dreamquiz/media/";
		
		if (!imgQeation.isEmpty() && imgQeation != null) {
			

  			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
  			String originalFileName = dateName + "-"
  					+ imgQeation.getOriginalFilename().replace(" ", "-").toLowerCase();
  			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
  			System.out.println("file name path "+ fileNameAndPath);
  			String path=serverip+"/DMImages/images/"+originalFileName;
  			try {
  				Files.write(fileNameAndPath, imgQeation.getBytes());
  			} catch (IOException e) {
  				e.printStackTrace();
  			}
  			String filepath=fileNameAndPath.toString();					
			queations.setImgQeation(path);
				} 
			
		else {

			queations.setImgQeation("");
		

		}

		if (!imgOptionA.isEmpty() && imgOptionA != null) {
			
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
  			String originalFileName = dateName + "-"
  					+ imgOptionA.getOriginalFilename().replace(" ", "-").toLowerCase();
  			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
  			System.out.println("file name path "+ fileNameAndPath);
  			String path=serverip+"/DMImages/images/"+originalFileName;
  			try {
  				Files.write(fileNameAndPath, imgOptionA.getBytes());
  			} catch (IOException e) {
  				e.printStackTrace();
  			}
  			String filepath=fileNameAndPath.toString();					
			queations.setImgOptionA(path);
				} 
			
		else {

			queations.setImgOptionA("");
		

		}




		if (!imgOptionB.isEmpty() && imgOptionB != null) {

			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
  			String originalFileName = dateName + "-"
  					+ imgOptionB.getOriginalFilename().replace(" ", "-").toLowerCase();
  			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
  			System.out.println("file name path "+ fileNameAndPath);
  			String path=serverip+"/DMImages/images/"+originalFileName;
  			try {
  				Files.write(fileNameAndPath, imgOptionB.getBytes());
  			} catch (IOException e) {
  				e.printStackTrace();
  			}
  			String filepath=fileNameAndPath.toString();					
			queations.setImgOptionB(path);
				} 
		
		
		else {

			queations.setImgOptionB("");
		

		}



		if (!imgOptionD.isEmpty() && imgOptionD != null) {

			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
  			String originalFileName = dateName + "-"
  					+ imgOptionD.getOriginalFilename().replace(" ", "-").toLowerCase();
  			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
  			System.out.println("file name path "+ fileNameAndPath);
  			String path=serverip+"/DMImages/images/"+originalFileName;
  			try {
  				Files.write(fileNameAndPath, imgOptionD.getBytes());
  			} catch (IOException e) {
  				e.printStackTrace();
  			}
  			String filepath=fileNameAndPath.toString();					
			queations.setImgOptionD(path);
				} 
		
		
		else {

			queations.setImgOptionD("");
		

		}

		
		if (!imgOptionC.isEmpty() && imgOptionC != null) {

			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
  			String originalFileName = dateName + "-"
  					+ imgOptionC.getOriginalFilename().replace(" ", "-").toLowerCase();
  			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
  			System.out.println("file name path "+ fileNameAndPath);
  			String path=serverip+"/DMImages/images/"+originalFileName;
  			try {
  				Files.write(fileNameAndPath, imgOptionC.getBytes());
  			} catch (IOException e) {
  				e.printStackTrace();
  			}
  			String filepath=fileNameAndPath.toString();					
			queations.setImgOptionC(path);
				} 
		else {

			queations.setImgOptionC("");
		

		}

		System.out.println("imgOptionC  aaaaa "+imgOptionC);
	
		
		addQuestionService.addnewqueation(queations);
		AppJsopnResponse resp = new AppJsopnResponse();
		resp.setMessage("Queation   saved successfully");
		resp.setStatus("True");
		return resp;
		
		
		}
	

	
	@RequestMapping(value = "/addcfpdf", method = RequestMethod.POST)

	public AppJsopnResponse addcfpdf(CurrentAffairs curentafairs,BindingResult bindingResult,@RequestParam("files") MultipartFile files,@RequestParam("thumbnail") MultipartFile thumbnail, HttpSession session) {
	  	
  	  File f = new File(allpdffiles);
			if (!f.exists()) {
				f.mkdirs();
			}

			File f2 = new File(uploadProductDirectory);
			if (!f2.exists()) {
				f2.mkdirs();
			}

		System.out.println(" pdf type   : "+files.getContentType());
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
			
			 if (!files.isEmpty()) {
		  			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		  			String originalFileName = dateName + "-"
		  					+ files.getOriginalFilename().replace(" ", "-").toLowerCase();
		  			Path fileNameAndPath = Paths.get(allpdffiles, originalFileName);
		  			System.out.println("file name path "+ fileNameAndPath);
		  			String path=serverip+"/pdffils/allpdffiles/"+originalFileName;
		  			System.out.println("allpdffiles    "+ path);
		  			try {
		  				Files.write(fileNameAndPath, files.getBytes());
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

	
	
	
	 
	@RequestMapping(value = "/findalloldpaperpdf", method = RequestMethod.GET)
	public List<OldPaper> findalloldpaperpdf() {
		return addQuestionService.getoldpaperpdf();
		
		
	}
	
	@RequestMapping(value = "/findallcurrentafairspdf", method = RequestMethod.GET)
	public List<CurrentAffairs> findallcurrentafairspdf() {
		return addQuestionService.getcurrentafairspdf();
		
		
	}
		
		@RequestMapping(value = "/AddNewVideodetails", method = RequestMethod.POST)
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
		
	
		@RequestMapping(value = "/AddNewExamDetails", method = RequestMethod.POST)
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

		
		
		
		
		
		
      @PostMapping("/uploadfiledurgesh")
		public ResponseEntity<String> uploadfiledurgesh(OldPaper oldpaper,@RequestParam("file") MultipartFile file) throws IOException  {
			
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        System.out.println(file.isEmpty());
       //application/pdf
    	
       
        try {
    	  
    	  if(file.isEmpty()) {
    		  
    		  
    		 return (ResponseEntity<String>) ResponceEntity.ok("File is Empty");
    	}
    	  
    	  
    	  if(!file.getContentType().equals("application/pdf")) {
    		  
    		  return (ResponseEntity<String>) ResponceEntity.ok("use only application pdf containt");
    		  
    		  
    	  }
    	  
  	  boolean f;
           f = FileUploadHelper.uploadFile(file);
	       System.out.println("value of f "+f);
            if(f) {
    		  
            	 System.out.println("in if controller");
    	  UriComponentsBuilder filepath=ServletUriComponentsBuilder.fromCurrentContextPath().path("/pdffiles/").path(file.getOriginalFilename().toString());
    	
    	  String s=filepath.toString();
    	  
    	  
    	  System.out.println("file path is :  "+ServletUriComponentsBuilder.fromCurrentContextPath().path("/pdffiles/").path(file.getOriginalFilename()).toUriString());
    	   return (ResponseEntity<String>) ResponceEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/pdffiles/").path(file.getOriginalFilename()).toUriString());
    		 
    	//  oldpaper.setOppdffile(ServletUriComponentsBuilder.fromCurrentContextPath().path("/pdffiles/").path(file.getOriginalFilename()).toUriString());
    	  
    	 // addQuestionService.addnewoldpaperpdf(oldpaper);
    	  
    //	  return (ResponseEntity<String>) ResponceEntity.ok("save old paper data successfully...!!!");
    	//  return (ResponseEntity<String>) ResponceEntity.status("1");
    	  
    	  }
    	  
    	  }
    	  catch(Exception e) {

  			e.printStackTrace();
  		}
    	  
    	  
        System.out.println("end");
    	  return (ResponseEntity<String>) ResponceEntity.ok("file not copy to folder...!!!");
			
					
}
      

      
      
//      
//      @RequestMapping(value="/uploadmultipartfile",method = RequestMethod.POST)
//  	public RegiResponce uploadmultipartfile(Doc doc, @RequestParam("files") MultipartFile[] files)throws Exception{
//    	  RegiResponce regi= new RegiResponce();
//  		for(MultipartFile file:files) {
//  			System.out.println("file name is "+file);
//  			
//  			
//  			addQuestionService.savefile(file);
//  			regi.setMessage("file save in db");  			
//  		}
//  		return regi;
//  	}
      
//      @RequestMapping(value = "/findaladbdata", method = RequestMethod.GET)
//  	public List<Doc> findaladbdata() {
//  		return addQuestionService.findaladbdata();
//  		
  		
//  	}
      
//      
//      
//      @PostMapping("/upload")
//      public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
//        String message = "";
//        try {
//        	addQuestionService.store(file);
//
//          message = "Uploaded the file successfully: " + file.getOriginalFilename();
//          return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
//        } catch (Exception e) {
//          message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//          return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
//        }
//      }
//
//      @GetMapping("/files")
//      public ResponseEntity<List<ResponseFile>> getListFiles() {
//        List<ResponseFile> files = addQuestionService.getAllFiles().map(dbFile -> {
//          String fileDownloadUri = ServletUriComponentsBuilder
//              .fromCurrentContextPath()
//              .path("/files/")
//              .path(dbFile.getId())
//              .toUriString();
//
//          return new ResponseFile(
//              dbFile.getName(),
//              fileDownloadUri,
//              dbFile.getType(),
//              dbFile.getData().length);
//        }).collect(Collectors.toList());
//
//        return ResponseEntity.status(HttpStatus.OK).body(files);
//      }
//
//      @GetMapping("/files/{id}")
//      public ResponseEntity<byte[]> getFile(@PathVariable String id) {
//        FileDB fileDB = addQuestionService.getFile(id);
//
//        return ResponseEntity.ok()
//            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
//            .body(fileDB.getData());
//      }
//      
      
      
      
      @PostMapping("/uploadfiledurgesh2")
    		public ResponseEntity<String> uploadfiledurgesh2(@RequestParam("file") MultipartFile file) throws IOException  {
    			
      
            if(file.isEmpty()) {
      		  
       		 return (ResponseEntity<String>) ResponceEntity.ok("File is Empty");
       	}
       	  
       	  if(!file.getContentType().equals("application/pdf")) {
       		  
       		  return (ResponseEntity<String>) ResponceEntity.ok("use only application pdf containt");		  
       	  }
       	  
       	   String UPLOAD_DIR="C:\\Users\\Dell\\git\\Spring2310Boot\\DreamQuiz\\src\\main\\resources\\static\\pdffiles";
       	 // File UPLOAD_DIR=new ClassPathResource("/static/pdffiles/").getFile().getAbsoluteFile();
       	  
       	  // String UPLOAD_DIR = "F://uploadtest/";
    	//	String UPLOAD_DIR="http://dreamquizs.com/dreamquizpdffiles/";
    	  
       	  
       	//  String UPLOAD_DIR="http://prismitservice.com/Vijay/";
            Files.copy(file.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
          
            return (ResponseEntity<String>) ResponceEntity.ok("file upload....!!");
      
      }
      
      
//      @RequestMapping(method = RequestMethod.POST, value = "/hi")
//      public String handleFileUpload(@RequestParam("file") MultipartFile file,
//                                     RedirectAttributes redirectAttributes) {
//    	  
//    	  String UPLOAD_DIR = "F://uploadtest/";
//    	  // String UPLOAD_DIR="http://dreamquizs.com/dreamquizpdffiles/";
//          if (!file.isEmpty()) { 
//              try { 
//                 
//                  Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR, file.getOriginalFilename()));
//                  redirectAttributes.addFlashAttribute("message","You successfully uploaded " + file.getOriginalFilename() + "!");
//              } catch (IOException|RuntimeException e) {
//                  redirectAttributes.addFlashAttribute("message", "Failued to upload " + file.getOriginalFilename() + " => " + e.getMessage());
//              }
//          } else {
//              redirectAttributes.addFlashAttribute("message", "Failed to upload " + file.getOriginalFilename() + " because it was empty");
//          }
//
//          return "ok";
//      }
//     "http://3.7.163.87/uploads/images"
  
      
      
      
      
//      @RequestMapping("/directory")
//  	public String manageBanner(Model model, HttpSession session) {
//  		
//  			File f = new File(uploadProductDirectory);
//  			if (!f.exists()) {
//  				f.mkdirs();
//
//  			}
//  			return "mkdir directory";
//  		
//  		
//
//  	}
//      
      @RequestMapping(value = "/save-OldPaper", method = RequestMethod.POST)
  
  	public AppJsopnResponse saveBanner(OldPaper oldpaper,BindingResult bindingResult,@RequestParam("thumbnail") MultipartFile thumbnail,@RequestParam("files") MultipartFile files, HttpSession session) {
  	
    	  File f = new File(allpdffiles);
			if (!f.exists()) {
				f.mkdirs();
			}
			File f2 = new File(uploadProductDirectory);
			if (!f2.exists()) {
				f2.mkdirs();
			}
			
			if (!files.isEmpty()) {
  			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
  			String originalFileName = dateName + "-"
  					+ files.getOriginalFilename().replace(" ", "-").toLowerCase();
  			Path fileNameAndPath = Paths.get(allpdffiles, originalFileName);
  			System.out.println("file name path "+ fileNameAndPath);
  			
  			String path=serverip+"/pdffils/allpdffiles/"+originalFileName;
  			try {
  				Files.write(fileNameAndPath, files.getBytes());
  			} catch (IOException e) {
  				e.printStackTrace();
  			}
  			String filepath=fileNameAndPath.toString();
  			 oldpaper.setOppdffile(path);
  			 System.out.println("check path  "+filepath);
  			 //oldpaper.setOppdffile(uploadProductDirectory+oldpaper.getOppdffile());
  			
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
    	  
    	  
    	  
  		AppJsopnResponse resp = new AppJsopnResponse();
  		
  	     resp.setMessage("file save in db...");
  		resp.setStatus("True");
  		resp.setData("");
  		return resp;
  	}  
    
     
      @RequestMapping(value = "/TopicsNotesPdf", method = RequestMethod.POST)

  	public AppJsopnResponse TopicsNotesPdf(Topicsnotespdf topicsNotesPdf,BindingResult bindingResult,@RequestParam("files") MultipartFile files,@RequestParam("thumbnail") MultipartFile thumbnail, HttpSession session) {
  	  	
    	  File f = new File(allpdffiles);
  			if (!f.exists()) {
  				f.mkdirs();
  			}
  			
  			File f2 = new File(uploadProductDirectory);
  			if (!f2.exists()) {
  				f2.mkdirs();
  			}

  	    
  		System.out.println(" pdf type   : "+files.getContentType());
  		
  		String topicsNotesPdftitlefrmuser=topicsNotesPdf.getTitle();
  	
  		System.out.println(" pdf name from user : "+topicsNotesPdftitlefrmuser);
  		List<String> alltopicsNotesPdf=addQuestionService.findalltopicsNotesPdf();
  		System.out.println(" pdf name listsize user : "+alltopicsNotesPdf);
  		
  		if(alltopicsNotesPdf.contains(topicsNotesPdftitlefrmuser)) {
  		
  			AppJsopnResponse resp = new AppJsopnResponse();
  			resp.setMessage("file  Allready exits ");
  			//resp.setStatus("True");
  			System.out.println("not save file");
  			return resp;
  			
  		}
  		else {
  			
  			 if (!files.isEmpty()) {
  		  			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
  		  			String originalFileName = dateName + "-"
  		  					+ files.getOriginalFilename().replace(" ", "-").toLowerCase();
  		  			Path fileNameAndPath = Paths.get(allpdffiles, originalFileName);
  		  			System.out.println("file name path "+ fileNameAndPath);
  		  		String path=serverip+"/pdffils/allpdffiles/"+originalFileName;
  		  			try {
  		  				Files.write(fileNameAndPath, files.getBytes());
  		  			} catch (IOException e) {
  		  				e.printStackTrace();
  		  			}
  		  			String filepath=fileNameAndPath.toString();
  		  		
  				
  		  		topicsNotesPdf.setPdffile(path);
  		  
  				
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
  		  		topicsNotesPdf.setThumbnail(path);
  				
  			}
  			
  		}
  					
  		addQuestionService.addnewtopicspdf(topicsNotesPdf);
  		
  		AppJsopnResponse resp = new AppJsopnResponse();
  		resp.setMessage("Save pdf file  success ");
  	    resp.setStatus("True");
  		System.out.println("success save pdf file");
  		
  		return resp;
  		}

	

      
      

  	@RequestMapping(value = "/addnewregister", method = RequestMethod.POST)

  	public NewRegiRepo addnewregister(NewRegister newRegister) {
  		
  		NewRegiRepo resp = new NewRegiRepo();
  		
  		
  		OTPServerMsg91 obj=new OTPServerMsg91();
  		Long genloginid=obj.generateSixDigitloginid();
  		String loginconvid=genloginid.toString();
  		System.out.println("loginconvid  :  "+loginconvid);
  		String pass =obj.generatePassword();
  		System.out.println("pass      :  "+pass);
  		
  		newRegister.setLoginid(loginconvid);
  		newRegister.setPassword(pass);
  		
  		addQuestionService.savenewregi(newRegister);
  		
  		
  		
  		
  		
  		resp.setMessage(" succss   ");
  		resp.setStatus("True");
  		resp.setPassword(pass);
  		resp.setLoginid(loginconvid);
  		
  			return resp;
  			
  		}
   
      
}
