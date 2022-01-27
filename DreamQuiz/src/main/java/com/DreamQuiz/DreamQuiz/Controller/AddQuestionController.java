package com.DreamQuiz.DreamQuiz.Controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.DreamQuiz.DreamQuiz.entity.AppJsopnResponse;
import com.DreamQuiz.DreamQuiz.entity.CurrentAffairs;
import com.DreamQuiz.DreamQuiz.entity.Examdetails;
import com.DreamQuiz.DreamQuiz.entity.OldPaper;
import com.DreamQuiz.DreamQuiz.entity.Queations;
import com.DreamQuiz.DreamQuiz.entity.SubTopics;
import com.DreamQuiz.DreamQuiz.entity.Subject;
import com.DreamQuiz.DreamQuiz.entity.Topics;
import com.DreamQuiz.DreamQuiz.entity.Videodetails;
import com.DreamQuiz.DreamQuiz.serviceimpl.AddQuestionServiceImpl;


@RestController

public class AddQuestionController {

	@Autowired
	AddQuestionServiceImpl addQuestionService;
	
	String uploadProductDirectory = System.getProperty("user.dir") + "/uploads/";

	
	
	
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

	public AppJsopnResponse addcfpdf(CurrentAffairs curentafairs,BindingResult bindingResult,
			@RequestParam("pdffile") List<MultipartFile> pdffile,HttpSession session) throws IOException  {
		
		
		String cfpdftitlefrmuser=curentafairs.getTitle();
	
		System.out.println(" pdf name from user : "+cfpdftitlefrmuser);
		List<String> catitlefrmdb=addQuestionService.findallcrpdftitle();
		System.out.println(" pdf name listsize user : "+catitlefrmdb);
		
		
//		String path = "/var/lib/tomcat8/webapps/Files/";
		// String path = "F://DQFiles/";
		String path="167.172.148.60:/home/dreamquiz/pdfmedia/";
		if(catitlefrmdb.contains(cfpdftitlefrmuser)) {
		
			AppJsopnResponse resp = new AppJsopnResponse();
			resp.setMessage("file  Allready exits ");
			//resp.setStatus("True");
			System.out.println("not save file");
			return resp;
			
		}
		else {
			
			for (MultipartFile multipartFile : pdffile) {
				String filename = multipartFile.getOriginalFilename();
				Random random = new Random();
				String randomnumber = String.format("%04d", random.nextInt(10000));
				filename = randomnumber + "" + filename;
				System.out.println(path + " " + filename);
				try {
					System.out.println("pdf file");
					byte barr[] = multipartFile.getBytes();
					BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
					bout.write(barr);
					bout.flush();
					bout.close();
					System.out.println("filename=" + filename);
					String filepath = path + filename;
					
					filepath = "http://167.172.148.60:/home/dreamquiz/pdfmedia/" +filename;
					// 34.87.81.128

				//	filepath = "F://DQFiles/" + filename;
				
					 curentafairs.setPdffile(filepath);
				} catch (Exception e) {

					e.printStackTrace();
				}
				
				
			}
			
		}
					
		addQuestionService.addnewcapdf(curentafairs);
		
		AppJsopnResponse resp = new AppJsopnResponse();
		resp.setMessage("Save pdf file  success ");
	    resp.setStatus("True");
		System.out.println("success save pdf file");
		
		return resp;
		}

	
	
	@RequestMapping(value = "/addoldpaper", method = RequestMethod.POST)

	public AppJsopnResponse addoldpaper(OldPaper oldpaper,BindingResult bindingResult,
			@RequestParam("oppdffile") List<MultipartFile> oppdffile,HttpSession session) throws IOException  {
		
		
		String oldpaperpdftitlefrmuser=oldpaper.getOptitle();
	
		System.out.println("  old paper pdf name from user : "+oldpaperpdftitlefrmuser);
		List<String> oldpapertitlefrmdb=addQuestionService.findoldpapertitle();
		System.out.println(" pdf name listsize user : "+oldpapertitlefrmdb);
		
		
	       //String path = "/home/dreamquiz/pdfmedia/";
		 String path = "F://DQOldPaperfile/";
	//	 String path ="/home/dreamquiz/pdfmedia/";
		if(oldpapertitlefrmdb.contains(oldpaperpdftitlefrmuser)) {
		
			AppJsopnResponse resp = new AppJsopnResponse();
			resp.setMessage("old paper pdf file  Allready exits ");
			resp.setStatus("True");
			System.out.println("not save file");
			return resp;
			
		}
		else {
			
			for (MultipartFile multipartFile : oppdffile) {
				String filename = multipartFile.getOriginalFilename();
				Random random = new Random();
				String randomnumber = String.format("%04d", random.nextInt(10000));
				filename = randomnumber + "" + filename;
				System.out.println(path + " " + filename);
				try {
					System.out.println("pdf file");
					byte barr[] = multipartFile.getBytes();
					BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
					bout.write(barr);
					bout.flush();
					bout.close();
					System.out.println("filename=" + filename);
					String filepath = path + filename;
					
					filepath = "http://167.172.148.60:/home/dreamquiz/pdfmedia/" +filename;
					// 34.87.81.128

				//	filepath = "F://DQOldPaperfile/" + filename;
					System.out.println("file null why "+filepath);
					oldpaper.setOppdffile(filepath);
				} catch (Exception e) {

					e.printStackTrace();
				}
				
				
			}
			
		}
					
		addQuestionService.addnewoldpaperpdf(oldpaper);
		
		AppJsopnResponse resp = new AppJsopnResponse();
		resp.setMessage("Save old paperpdf file  success ");
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

		
		
		
		
		
		
		
		
		
}
