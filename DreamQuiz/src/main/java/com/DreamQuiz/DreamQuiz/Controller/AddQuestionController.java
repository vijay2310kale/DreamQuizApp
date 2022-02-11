package com.DreamQuiz.DreamQuiz.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.DreamQuiz.DreamQuiz.Configuration.FileUploadHelper;
import com.DreamQuiz.DreamQuiz.entity.AppJsopnResponse;
import com.DreamQuiz.DreamQuiz.entity.CurrentAffairs;
//import com.DreamQuiz.DreamQuiz.entity.Doc;
import com.DreamQuiz.DreamQuiz.entity.Examdetails;
//import com.DreamQuiz.DreamQuiz.entity.FileDB;
import com.DreamQuiz.DreamQuiz.entity.OldPaper;
import com.DreamQuiz.DreamQuiz.entity.Queations;
import com.DreamQuiz.DreamQuiz.entity.SubTopics;
import com.DreamQuiz.DreamQuiz.entity.Subject;
import com.DreamQuiz.DreamQuiz.entity.Topics;
import com.DreamQuiz.DreamQuiz.entity.Videodetails;
import com.DreamQuiz.DreamQuiz.serviceimpl.AddQuestionServiceImpl;




@RestController

public class AddQuestionController {

	private static final ResponseEntity<String> ResponceEntity = null;

	@Autowired
	AddQuestionServiceImpl addQuestionService;
	@Autowired
	FileUploadHelper fileUploadHelper;
	
	String uploadProductDirectory = System.getProperty("user.dir") + "/uploads/images";
	String uploadpdfDirectory = System.getProperty("user.dir") + "/uploads/pdf";
	
	String serverip="http://3.7.163.87";
	//String uploadProductDirectory = "http://prismitservice.com/Vijay/";
	//http://dreamquizs.com/dreamquizpdffiles/
	
	
	@RequestMapping(value = "/AddNewSubject", method = RequestMethod.POST)

	public AppJsopnResponse addNewSubject(Subject subject) {
		
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

	public AppJsopnResponse addnewtopic(Topics topics) {
		
		
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
			@RequestParam("imgQeation") List<MultipartFile> imgQeation,
			@RequestParam("imgOptionA") List<MultipartFile> imgOptionA,
			@RequestParam("imgOptionB") List<MultipartFile> imgOptionB,
			@RequestParam("imgOptionC") List<MultipartFile> imgOptionC,
			@RequestParam("imgOptionD") List<MultipartFile> imgOptionD,HttpSession session) throws IOException {
		
		
		
		//long qid=	queations.getQid();
		long lastprimaryid= addQuestionService.getlastinsertpid();
		System.out.println("lastprimaryid "+lastprimaryid);
		long plusone_lastprimaryid=lastprimaryid+1;
		System.out.println("plusone_lastprimaryid  "+plusone_lastprimaryid);
		String s_=String.valueOf(plusone_lastprimaryid);
		
		System.out.println("plusone_lastprimaryid String "+ s_);
		
		
	//	String path = "/var/lib/tomcat8/webapps/Files/";
	// String path = "F://DQImages/";
	String path= "167.172.148.60:/home/dreamquiz/media/";
		
		if (!imgQeation.isEmpty() && imgQeation != null) {
			
			
			for (MultipartFile multipartFile : imgQeation) {
				String filename = multipartFile.getOriginalFilename();
				Random random = new Random();
				String randomnumber = String.format("%04d", random.nextInt(10000));
				filename = randomnumber + "" + filename;
				System.out.println(path + " " + filename);
				try {
					System.out.println("file image ");
					byte barr[] = multipartFile.getBytes();
					BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
					bout.write(barr);
					bout.flush();
					bout.close();
					System.out.println("filename=" + filename);
					String imagepath = path + filename;
					
					imagepath ="http://167.172.148.60:/home/dreamquiz/media/" +filename;
					// 34.87.81.128

					// imagepath = "F://DQImages/" + filename;
				
					//int fileupload = service.insertImageFile(uid, imagepath);
					
					
					queations.setImgQeation(imagepath);
				} catch (Exception e) {

					e.printStackTrace();
				}
				
				
			}
			
		}
		else {

			queations.setImgQeation("");
		

		}

		if (!imgOptionA.isEmpty() && imgOptionA != null) {
			
			
			
			for (MultipartFile multipartFile : imgOptionA) {
				String filename = multipartFile.getOriginalFilename();
				Random random = new Random();
				String randomnumber = String.format("%04d", random.nextInt(10000));
				filename = randomnumber + "" + filename;
				System.out.println(path + " " + filename);
				try {
					System.out.println("file image ");
					byte barr[] = multipartFile.getBytes();
					BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
					bout.write(barr);
					bout.flush();
					bout.close();
					System.out.println("filename=" + filename);
					String imagepath = path + filename;
					
					imagepath = "http://167.172.148.60:/home/dreamquiz/media/" +filename;
					// 34.87.81.128

					// imagepath = "F://DQImages/" + filename;
				
					//int fileupload = service.insertImageFile(uid, imagepath);
					
					
					queations.setImgOptionA(imagepath);
				} catch (Exception e) {

					e.printStackTrace();
				}
				
				
			}
			
		}
		else {

			queations.setImgOptionA("");
		

		}



		if (!imgOptionB.isEmpty() && imgOptionB != null) {

			for (MultipartFile multipartFile : imgOptionB) {
				String filename =multipartFile.getOriginalFilename();
				Random random = new Random();
				String randomnumber = String.format("%04d", random.nextInt(10000));
				filename = randomnumber + "" + filename;
				System.out.println(path + " " + filename);
				try {
					System.out.println("file image ");
					byte barr[] = multipartFile.getBytes();
					BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
					bout.write(barr);
					bout.flush();
					bout.close();
					System.out.println("filename=" + filename);
					String imagepath = path + filename;
					
					imagepath = "http://167.172.148.60:/home/dreamquiz/media/" +filename;
					// 34.87.81.128

					 imagepath = "F://DQImages/" + filename;
				
					//int fileupload = service.insertImageFile(uid, imagepath);
					
					
					queations.setImgOptionB(imagepath);
				} catch (Exception e) {

					e.printStackTrace();
				}
				
				
			}
			
		}
		else {

			queations.setImgOptionB("");
		

		}



		if (!imgOptionD.isEmpty() && imgOptionD != null) {

			for (MultipartFile multipartFile : imgOptionD) {
				String filename =multipartFile.getOriginalFilename();
				Random random = new Random();
				String randomnumber = String.format("%04d", random.nextInt(10000));
				filename = randomnumber + "" + filename;
				System.out.println(path + " " + filename);
				try {
					System.out.println("file image ");
					byte barr[] = multipartFile.getBytes();
					BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
					bout.write(barr);
					bout.flush();
					bout.close();
					System.out.println("filename=" + filename);
					String imagepath = path + filename;
					
					imagepath = "http://167.172.148.60:/home/dreamquiz/media/" +filename;
					// 34.87.81.128

					 imagepath = "F://DQImages/" + filename;
				
					//int fileupload = service.insertImageFile(uid, imagepath);
					
					
					queations.setImgOptionD(imagepath);
				} catch (Exception e) {

					e.printStackTrace();
				}
				
				
			}
			
		}
		else {

			queations.setImgOptionD("");
		

		}

		
		if (!imgOptionC.isEmpty() && imgOptionC != null) {

			for (MultipartFile multipartFile : imgOptionC) {
				String filename =multipartFile.getOriginalFilename();
				Random random = new Random();
				String randomnumber = String.format("%04d", random.nextInt(10000));
				filename = randomnumber + "" + filename;
				System.out.println(path + " " + filename);
				try {
					System.out.println("file image ");
					byte barr[] = multipartFile.getBytes();
					BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
					bout.write(barr);
					bout.flush();
					bout.close();
					System.out.println("filename=" + filename);
					String imagepath = path + filename;
					
					imagepath ="http://167.172.148.60:/home/dreamquiz/media/" +filename;
					// 34.87.81.128

					// imagepath = "F://DQImages/" + filename;
				
					//int fileupload = service.insertImageFile(uid, imagepath);
					
					
					queations.setImgOptionC(imagepath);
				} catch (Exception e) {

					e.printStackTrace();
				}
				
				
			}
			
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

	public AppJsopnResponse addcfpdf(CurrentAffairs curentafairs,@RequestParam("files") MultipartFile files, BindingResult bindingResult,HttpSession session) {
	  	
  	  File f = new File(uploadpdfDirectory);
			if (!f.exists()) {
				f.mkdirs();
			}

	    
		System.out.println(" pdf type   : "+files.getContentType());
		
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
		  			Path fileNameAndPath = Paths.get(uploadpdfDirectory, originalFileName);
		  			System.out.println("file name path "+ fileNameAndPath);
		  			try {
		  				Files.write(fileNameAndPath, files.getBytes());
		  			} catch (IOException e) {
		  				e.printStackTrace();
		  			}
		  			String filepath=fileNameAndPath.toString();
		  		
				
					 curentafairs.setPdffile(serverip+filepath);
				
				
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
  
  	public AppJsopnResponse saveBanner(OldPaper oldpaper,@RequestParam("files") MultipartFile files, BindingResult bindingResult,HttpSession session) {
  	
    	  File f = new File(uploadProductDirectory);
			if (!f.exists()) {
				f.mkdirs();
			}
    	  
    	  if (!files.isEmpty()) {
  			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
  			String originalFileName = dateName + "-"
  					+ files.getOriginalFilename().replace(" ", "-").toLowerCase();
  			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
  			System.out.println("file name path "+ fileNameAndPath);
  			try {
  				Files.write(fileNameAndPath, files.getBytes());
  			} catch (IOException e) {
  				e.printStackTrace();
  			}
  			String filepath=fileNameAndPath.toString();
  			 oldpaper.setOppdffile(serverip+filepath);
  			 System.out.println("check path  "+filepath);
  			 //oldpaper.setOppdffile(uploadProductDirectory+oldpaper.getOppdffile());
  			addQuestionService.addnewoldpaperpdf(oldpaper);
  		} else {
  			
  			 oldpaper.setOppdffile("");
  		}
  		AppJsopnResponse resp = new AppJsopnResponse();
  		
  	     resp.setMessage("file save in db...");
  		resp.setStatus("True");
  		resp.setData("");
  		return resp;
  	}

   
      //sftp://ubuntu@3.7.163.87/home/ubuntu/project/uploads
      
      
      
          
      
      
}
